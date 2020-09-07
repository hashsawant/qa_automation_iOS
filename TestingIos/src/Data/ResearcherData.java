package Data;

public class ResearcherData implements IDataLoader {
	
	private String fName;
	private String lName;
	private String email;
	private String password;
	private String keywordFilter;
	private String authorFilter;
	private String searchKeyword;
	private String journalName;
	private String TestCases;

	public void Load(String[] data) {
		
		if (data[0] != null) {
			this.fName = data[0].toString();
		}
		if (data[1] != null) {
			this.lName = data[1].toString();
		}
		if (data[2] != null) {
			this.email = data[2].toString();
		}
		if (data[3] != null) {
			this.password = data[3].toString();
		}
		if (data[4] != null) {
			this.keywordFilter = data[4].toString();
		}
		if (data[5] != null) {
			this.authorFilter = data[5].toString();
		}
		if (data[6] != null) {
			this.searchKeyword = data[6].toString();
		}
		if (data[7] != null) {
			this.journalName = data[7].toString();
		}
		if (data[8] != null) {
			this.TestCases = data[8].toString();
		}
		
	}

	public String getFileName() {
		return "ResearcherData";
	}

	public String getfname() {
		return this.fName;
	}

	public String getlname() {
		return this.lName;
	}

	public String getemail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public String getkeywordfilter() {
		return this.keywordFilter;
	}

	public String getauthorfilter() {
		return this.authorFilter;
	}

	public String getSearchKeyword() {
		return this.searchKeyword;
	}

	public String getJournalName() {
		return this.journalName;
	}

	public String getTestCases() {
		return this.TestCases;
	}
	
}
