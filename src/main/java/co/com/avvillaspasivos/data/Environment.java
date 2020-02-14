package co.com.avvillaspasivos.data;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:data.properties"})
public interface Environment extends Config {

  String usersType();

  String users();

  String customerConditions();

  String identificationProject();

  String psworacle();
}
