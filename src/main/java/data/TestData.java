package data;

public class TestData {
		public static String url,username,password;
				
	public TestData(String env){
		if (env.equalsIgnoreCase("QAI")){
		
			//-----QA TEST DATA-----// Set QA test data here
			 url="https://auth-qa.mercer.com/QAWORK/login";
			 username="auto_qawork0004@mas.com";
			 password="QAWORKpass2";			
		}
		
		else if (env.equalsIgnoreCase("PROD")){
			
			//-----PROD TEST DATA-----// Set PROD test data here
			 url="https://auth.mercer.com/SLSDM/login";
			 username="auto_SLSDM1002@mas.com";
			 password="SLSDMpass1";	
		}
	}
}
