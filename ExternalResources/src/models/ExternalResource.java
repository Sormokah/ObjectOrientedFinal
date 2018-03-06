package models;



public class ExternalResource {
	private String link;
	private String content;
	
	public ExternalResource(String link, String content) {
		setLink(link);
		setContent(content);
	}
	
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	
	public String getLink() {
		return link;
	}
	
	public String getContent() {
		return content;
	}
	

}
