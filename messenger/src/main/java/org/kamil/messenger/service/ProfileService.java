package org.kamil.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.kamil.messenger.database.DatabaseClass;
import org.kamil.messenger.model.Profile;

public class ProfileService {

	public ProfileService() {
		profiles.put("almanahc978", new Profile(1L, "almanahc978", "Kamil", "Zalewski", new Date()));
		profiles.put("cequ", new Profile(2L, "cequ", "Patryk", "Czajkowski", new Date()));
	}

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.replace(profile.getProfileName(), profile);
		return profile;
	}

	public void removeProfile(String profileName) {
		profiles.remove(profileName);
	}

}
