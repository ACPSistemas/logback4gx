/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acp.logback4gx;

import ch.qos.logback.core.PropertyDefinerBase;
import com.genexus.Application;
import com.genexus.ApplicationContext;
import com.genexus.ClientPreferences;
import com.genexus.util.IniFile;

/**
 *
 * @author scardello
 */

public class GxPropertyReader extends PropertyDefinerBase {
    
    public static String DBUSERPROPERTY = "USER_ID";
    public static String DBUSERPASSPROPERTY = "USER_PASSWORD";
    public static String DBURLPASSPROPERTY = "DB_URL";
    public static String DBDRIVERPROPERTY = "JDBC_DRIVER";
    
    String name;
    String section;
    String dataStore;
    String defaultValue;
    
    public String getDataStore() {
        return dataStore;
    }

    public void setDataStore(String dataStore) {
        this.dataStore = dataStore;
    }
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPropertyValue() {
      return (dataStore != null && !dataStore.isEmpty())? getGxDataStoreProperty(dataStore, name, defaultValue) : getGxProperty(section, name, defaultValue);   
    }  

    public static String getGxProperty(String section, String name, String defaultValue) {
        String propVal = null;
        //sin un nombre válido ni me gasto en buscar la propiedad
        if (name != null && !name.isEmpty() ) {          
            try {
                if (section != null && !section.isEmpty() ) {
                    propVal = getGxClientPreferences().getProperty(section, name, defaultValue);
                } else {
                    propVal = getGxClientPreferences().getProperty(name, defaultValue);
                }
            } catch(Exception e) {
                System.out.println(getRootCause(e).getMessage());
            }   
        }
        return propVal;
    }
    
    public static String getGxDataStoreProperty(String dataStore, String propertyName, String defaultValue) {
        String propVal = null;
        if (propertyName != null && !propertyName.isEmpty() ) {
            if (dataStore == null || dataStore.isEmpty() ) 
                dataStore = "default";
            String sectionName = "default" + "|" + dataStore;
            try {
                if (propertyName.equals("USER_ID") ||  propertyName.equals("USER_PASSWORD")) {  
                    propVal = getGxClientPreferences().getIniFile().getPropertyEncrypted(sectionName,propertyName,defaultValue);
                } else {
                    propVal = getGxProperty(sectionName,propertyName,defaultValue);
                }
            } catch(Exception e) {
                System.out.println("Logback4gx GxPropertyReader Error: " + getRootCause(e).toString());
            }                
        }
        return propVal;
    }
    
    public static String getGxDataStoreProperty(String propertyName, String defaultValue) {
        return getGxDataStoreProperty("",propertyName,defaultValue);
    }
    
    public static String getGxDataStoreProperty(String propertyName) {
        return getGxDataStoreProperty("",propertyName,"");
    }
    
    public static String getGxDataStoreUser(String dataStore, String defaultValue) {
        return getGxDataStoreProperty(dataStore,DBUSERPROPERTY,defaultValue);
    }    
    
    public static String getGxDataStoreUser(String dataStore) {
        return getGxDataStoreUser(dataStore,"");
    }        
    
    public static String getGxDataStoreUser() {
        return getGxDataStoreUser("");
    }
    
    public static String getGxDataStoreUrl(String dataStore, String defaultValue) {
        return getGxDataStoreProperty(dataStore,DBURLPASSPROPERTY,defaultValue);
    }    
    
    public static String getGxDataStoreUrl(String dataStore) {
        return getGxDataStoreUrl(dataStore,"");
    }        
    
    public static String getGxDataStoreUrl() {
        return getGxDataStoreUrl("");
    }      
    
    public static String getGxDataStorePass(String dataStore, String defaultValue) {
        return getGxDataStoreProperty(dataStore,DBUSERPASSPROPERTY,defaultValue);
    }    
    
    public static String getGxDataStorePass(String dataStore) {
        return getGxDataStorePass(dataStore,"");
    }        
    
    public static String getGxDataStorePass() {
        return getGxDataStorePass("");
    }
    
    public static String getGxDataStoreDriver(String dataStore, String defaultValue) {
        return getGxDataStoreProperty(dataStore,DBDRIVERPROPERTY,defaultValue);
    }    
    
    public static String getGxDataStoreDriver(String dataStore) {
        return getGxDataStoreDriver(dataStore,"");
    }        
    
    public static String getGxDataStoreDriver() {
        return getGxDataStoreDriver("");
    }    
   
    private static ClientPreferences getGxClientPreferences() throws ClassNotFoundException  {
            ApplicationContext.getInstance().setCurrentLocation("");
            Application.init(Class.forName("GXcfg"));
            return Application.getClientContext().getClientPreferences();
    }
    
    private static Throwable getRootCause(Throwable throwable) {
        if (throwable.getCause() != null)
            return getRootCause(throwable.getCause());

        return throwable;
    }

}

