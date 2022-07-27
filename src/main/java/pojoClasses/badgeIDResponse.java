package pojoClasses;

import java.net.URL;
import java.util.List;

public class badgeIDResponse 
{
	private List<itemsList> items;
	private boolean has_more;
	private int quota_max;
	private int quota_remaining;
	
	
	public List<itemsList> getItems() {
		return items;
	}
	public void setItems(List<itemsList> items) {
		this.items = items;
	}
	public boolean isHas_more() {
		return has_more;
	}
	public void setHas_more(boolean has_more) {
		this.has_more = has_more;
	}
	public int getQuota_max() {
		return quota_max;
	}
	public void setQuota_max(int quota_max) {
		this.quota_max = quota_max;
	}
	public int getQuota_remaining() {
		return quota_remaining;
	}
	public void setQuota_remaining(int quota_remaining) {
		this.quota_remaining = quota_remaining;
	}
	
	
	static class itemsList
	{
		private String badge_type;
		private int award_count;
		private String rank;
		private int badge_id;
		private URL link;
		private String name;
		
		public String getBadge_type() {
			return badge_type;
		}
		public void setBadge_type(String badge_type) {
			this.badge_type = badge_type;
		}
		public int getAward_count() {
			return award_count;
		}
		public void setAward_count(int award_count) {
			this.award_count = award_count;
		}
		public String getRank() {
			return rank;
		}
		public void setRank(String rank) {
			this.rank = rank;
		}
		public int getBadge_id() {
			return badge_id;
		}
		public void setBadge_id(int badge_id) {
			this.badge_id = badge_id;
		}
		public URL getLink() {
			return link;
		}
		public void setLink(URL link) {
			this.link = link;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}
