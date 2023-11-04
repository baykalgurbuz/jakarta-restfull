package jakartarest;

import jakarta.ws.rs.ApplicationPath;
//servlet yazmadığımız için giriş kapısıolarak applicationpath yazarak giriş kapısını gösteriyoruz
@ApplicationPath(value = "/")
public class Application extends jakarta.ws.rs.core.Application{

}
