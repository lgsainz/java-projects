/**
 * This class represents web pages through a URL,
 * a short description, and a rating.
 * This class is used in WebFavorites.java
 * @author Leticia Garcia-Sainz
 * @version 10-11-2015
 */

public class WebPage {

	private String url;
	private String description;
	private String rating;

	/**
	 * Construct a new Web page.
	 * @param url the url of the web page
	 * @param description the description of the web page
	 * @param rating the rating
	 */
	public WebPage(String url, String description, String rating) {
		this.url = url;
		this.description = description;
		this.rating = rating;
	}
	
	/**
	 * Returns the web page URL.
	 * @return the URL
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Returns the web page description.
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Returns the web page rating.
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	
	/**
	 * Generates a new hashcode.
	 * @return h the hashcode
	 */
	public int hashCode() {
		final int HASH_MULTIPLIER = 31;
		int h = 0;
		String s = this.getUrl();

		for (int i = 0; i < s.length(); i++) {
			h = HASH_MULTIPLIER * h + s.charAt(i);
		}
		return h;
	}
	
	
	/**
	 * Overrides the toString method to return appropriate format
	 */
	public String toString() {
		return "URL: " + this.url + ". Description: " + this.description + ". Rating: " +
				 this.rating;
	}
	
	/**
	 * Overrides equals method to compare webpages.
	 */
	public boolean equals(Object obj) {
		WebPage other = (WebPage) obj;
		if (this.getUrl().equals(other.getUrl())) {
			return true;
		}
		return false;
	}
	
}
