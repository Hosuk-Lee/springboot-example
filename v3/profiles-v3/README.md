spring profile이 여러개 동시에 선언이 되었다면 적용 우선순위는 다음과 같다.

web.xml의 ContextParameter
WebApplicationInitializer
JVM system arguments
OS 환경 변수
Maven Profile

public class ProfileManager { @Autowired private Environment environment; public void getActiveProfiles() { for (String
profileName : environment.getActiveProfiles()) { System.out.println("Currently active profile - " + profileName); } } }


