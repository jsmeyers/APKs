import Helper from './helper.js';

export default class ThemerService {
  static getAPIDomainByEnv(envName) {
    switch (envName) {
      case 'sandbox':
        return `https://sandbox-api.relationshop.net`;
      case 'stg':
        return `https://stg-api.relationshop.net`;
      case 'uat':
        return `https://uat-api.relationshop.net`;
      case 'dxpro.staging':
        return `https://stg-api-dxpro.mercatus.com/gateway`;
      case 'dxpro.uat':
        return `https://uat-api-dxpro.mercatus.com/gateway`;
      case 'dxpro.production':
        return `https://uat-api-dxpro.mercatus.com/gateway`;
      case 'prod':
        return `https://api.relationshop.net`;
      default:
        return `http://localhost`;
    }
  }

  static async validateAdminToken(envName, username, token) {
    if (!username || !token) return false;
    const url = `${this.getAPIDomainByEnv(envName)}/identity/v1.0/api/Users/0/GetByUserName?un=${username}`;

    try {
      const headers = {
        'Content-Type': 'application/json',
      };
      headers['Authorization'] = `Bearer ${token}`;
      const res = await fetch(url, {
        method: 'GET',
        body: null,
        headers,
      });

      const result = await res.json();
      if (res.ok) return true;

      console.error({
        type: 'Error',
        message: result.Title || result.Message || result.message || 'Something went wrong',
        data: result.Data || '',
        code: result.Code || '',
        internalCode: result.InternalCode || '',
      });
      return false;
    } catch (error) {
      console.error({
        type: 'Error',
        message: error.message || '',
        data: null,
        code: error.code || '',
      });
      return false;
    }
  }

  static async getTenantSettingBySiteCode(envName, tenantId, appCode, token) {
    if (!tenantId || !appCode || !token) {
      console.error('Tenant ID, Site Code or Auth Token is undefined!');
      return null;
    }
    const headers = {
      'Content-Type': 'application/json',
    };
    headers['Authorization'] = `Bearer ${token}`;
    const res = await fetch(
      `${this.getAPIDomainByEnv(envName)}/tenant/v1.0/api/TenantSetting/GetTenantSettingByPlatform?tenantId=${tenantId}&platform=AppSettings`,
      {
        method: 'GET',
        body: null,
        headers,
      }
    );

    const settings = await res.json();
    if (!res.ok) {
      console.error('Something went wrong when fetching the all tenant settings!');
      return null;
    }

    const setting = settings.find((s) => s.SiteCode === appCode);

    if (!setting) {
      console.error('Setting not found!');
      return null;
    }

    return { ...setting };
  }

  /**
   *
   * @param {*} tokens
   * @returns New theme configuration
   */
  static async saveTokens(tokens) {
    const themeConfigStr = sessionStorage.getItem(Helper.THEMER_SESSION_KEY);
    if (!themeConfigStr) return false;
    const themeConfig = JSON.parse(themeConfigStr);
    const { tk, tid, en, ac, tnid } = themeConfig;

    const setting = await ThemerService.getTenantSettingBySiteCode(en, tnid, ac, tk);
    if (!setting?.ThemeConfigurations) {
      console.error('Theme configurations not found!');
      return null;
    }

    try {
      // Parse ThemeConfigurations and find the index of the current theme
      const themes = JSON.parse(setting.ThemeConfigurations);
      const themeIndex = themes.findIndex((t) => t.Id === tid);

      if (themeIndex === -1 || !themes[themeIndex].Configurations) {
        console.error('No selected theme found!');
        return null;
      }

      // Parse the theme configuration for modifications
      const themeToModify = JSON.parse(themes[themeIndex].Configurations);

      if (!themeToModify.globalCss[':root']) {
        console.error('Cannot find the global CSS object!');
        return null;
      }

      // Apply each token update directly to globalCss[':root']
      Object.keys(tokens).forEach((tokenKey) => {
        themeToModify.globalCss[':root'][tokenKey] = tokens[tokenKey].newValue;
      });

      // Update themes array with modified theme configuration
      themes[themeIndex].Configurations = JSON.stringify(themeToModify);

      // Update the setting.ThemeConfigurations with the modified themes array
      setting.ThemeConfigurations = JSON.stringify(themes);
      const isSuccess = await ThemerService.saveTenantSetting(tk, { ...setting }, en);
      return isSuccess ? themeToModify : null;
    } catch (err) {
      console.error('Error updating theme configuration:', err);
      return null;
    }
  }

  static async saveTenantSetting(token, payload, envName) {
    if (!payload?.TenantId || !payload?.SiteCode) {
      console.error('Tenant ID or Site Code is undefined!');
      return null;
    }
    const headers = {
      'Content-Type': 'application/json',
    };
    headers['Authentication'] = `Bearer ${token}`;
    const res = await fetch(`${this.getAPIDomainByEnv(envName)}/tenant/v1.0/api/TenantSetting/CreateOrUpdate`, {
      method: 'POST',
      body: JSON.stringify(payload),
      headers,
    });

    await res.json();

    if (!res.ok) {
      console.error('Something went wrong when saving the tenant settings!');
      return null;
    }

    return true;
  }
}
