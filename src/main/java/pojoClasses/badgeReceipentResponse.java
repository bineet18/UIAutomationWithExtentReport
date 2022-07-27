package pojoClasses;

import java.net.URL;
import java.util.List;

public class badgeReceipentResponse 
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
		private userClass user;
		private String badge_type;
		private String rank;
		private int badge_id;
		private URL link;
		private String name;
		
		public userClass getUser() {
			return user;
		}
		public void setUser(userClass user) {
			this.user = user;
		}
		public String getBadge_type() {
			return badge_type;
		}
		public void setBadge_type(String badge_type) {
			this.badge_type = badge_type;
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


		static class userClass
		{
			private int account_id;
			private int reputation;
			private int user_id;
			private String user_type;
			private int accept_rate;
			private URL profile_image;
			private String display_name;
			private URL link;
			
			public int getAccount_id() {
				return account_id;
			}
			public void setAccount_id(int account_id) {
				this.account_id = account_id;
			}
			public int getReputation() {
				return reputation;
			}
			public void setReputation(int reputation) {
				this.reputation = reputation;
			}
			public int getUser_id() {
				return user_id;
			}
			public void setUser_id(int user_id) {
				this.user_id = user_id;
			}
			public String getUser_type() {
				return user_type;
			}
			public void setUser_type(String user_type) {
				this.user_type = user_type;
			}
			public int getAccept_rate() {
				return accept_rate;
			}
			public void setAccept_rate(int accept_rate) {
				this.accept_rate = accept_rate;
			}
			public URL getProfile_image() {
				return profile_image;
			}
			public void setProfile_image(URL profile_image) {
				this.profile_image = profile_image;
			}
			public String getDisplay_name() {
				return display_name;
			}
			public void setDisplay_name(String display_name) {
				this.display_name = display_name;
			}
			public URL getLink() {
				return link;
			}
			public void setLink(URL link) {
				this.link = link;
			}
		}
	}



}
