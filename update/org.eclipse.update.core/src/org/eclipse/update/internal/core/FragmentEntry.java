/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.update.internal.core;


/**
 * This class is used to retrieve the fragments associated with a plugin.
 */
public class FragmentEntry {

	private static FragmentEntry[] noFragments = new FragmentEntry[0];
	
	private String pluginId;
	private String pluginVersion;
	private String name; 
	private String location;
	
	public FragmentEntry(String id, String version, String name, String location) {
		this.pluginId = id;
		this.pluginVersion = version;
		this.name = name;
		this.location = location;
	}

	/**
	 * @return the plugin translatable name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the location of the plugin
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Returns the plug-in identifier for this entry.
	 * 
	 * @return the plug-in identifier, or <code>null</code>
	 */
	public String getPluginIdentifier() {
		return pluginId;
	}

	/**
	 * Returns the plug-in version for this entry.
	 * 
	 * @return the plug-in version, or <code>null</code>
	 */
	public String getPluginVersion() {
		return pluginVersion;
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() {
		String msg = (getPluginIdentifier()!=null)?getPluginIdentifier().toString():"";
		msg += getPluginVersion()!=null?" "+getPluginVersion().toString():"";
		return msg;
	}
}