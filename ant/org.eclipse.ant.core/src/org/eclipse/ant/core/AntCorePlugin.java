/**********************************************************************
 * Copyright (c) 2002 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v0.5
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v05.html
 * 
 * Contributors: 
 * IBM - Initial API and implementation
 **********************************************************************/
package org.eclipse.ant.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ant.internal.core.AntCorePreferences;
import org.eclipse.ant.internal.core.IAntCoreConstants;
import org.eclipse.core.runtime.*;

public class AntCorePlugin extends Plugin implements IAntCoreConstants {

	/**
	 * The single instance of this plug-in runtime class.
	 */
	private static AntCorePlugin plugin;

	/**
	 * Table of Ant tasks (IConfigurationElement) added through the tasks extension point
	 */
	private Map taskExtensions;

	/**
	 * Table of Ant objects (IConfigurationElement) added through the objects extension point
	 */
	private Map objectExtensions;

	/**
	 * Table of Ant ypes (IConfigurationElement) added through the types extension point
	 */
	private Map typeExtensions;

	/**
	 * 
	 */
	private AntCorePreferences preferences;

	/**
	 * Unique identifier constant (value <code>"org.eclipse.ant.core"</code>)
	 * for the Ant Core plug-in.
	 */
	public static final String PI_ANTCORE= "org.eclipse.ant.core";

	/**
	 * Simple identifier constant (value <code>"antTasks"</code>)
	 * for the Ant tasks extension point.
	 */
	public static final String PT_TASKS = "antTasks";

	/**
	 * Simple identifier constant (value <code>"antObjects"</code>)
	 * for the Ant tasks extension point.
	 */
	public static final String PT_OBJECTS = "antObjects";

	/**
	 * Simple identifier constant (value <code>"antTypes"</code>)
	 * for the Ant tasks extension point.
	 */
	public static final String PT_TYPES = "antTypes";

	/**
	 * Simple identifier constant (value <code>"class"</code>)
	 * of a tag that appears in Ant extensions.
	 */
	public static final String CLASS = "class";

	/**
	 * Simple identifier constant (value <code>"name"</code>)
	 * of a tag that appears in Ant extensions.
	 */
	public static final String NAME = "name";

	/**
	 * Simple identifier constant (value <code>"library"</code>)
	 * of a tag that appears in Ant extensions.
	 */
	public static final String LIBRARY = "library";

public AntCorePlugin(IPluginDescriptor descriptor) {
	super(descriptor);
	plugin = this;
}

public void startup() throws CoreException {
	taskExtensions = extractExtensions(PT_TASKS);
	objectExtensions = extractExtensions(PT_OBJECTS);
	typeExtensions = extractExtensions(PT_TYPES);
}

public void shutdown() throws CoreException {
	if (preferences == null)
		return;
	preferences.updatePluginPreferences();
	savePluginPreferences();
}

protected Map extractExtensions(String point) {
	IExtensionPoint extensionPoint = getDescriptor().getExtensionPoint(point);
	if (extensionPoint == null)
		return null;
	IConfigurationElement[] extensions = extensionPoint.getConfigurationElements();
	Map result = new HashMap(extensions.length);
	for (int i = 0; i < extensions.length; i++) {
		String name = extensions[i].getAttribute(NAME);
		result.put(name, extensions[i]);
	}
	return result;
}

public AntCorePreferences getPreferences() {
	if (preferences == null)
		preferences = new AntCorePreferences(taskExtensions, objectExtensions, typeExtensions);
	return preferences;
}

/**
 * Returns this plug-in.
 *
 * @return the single instance of this plug-in runtime class
 */
public static AntCorePlugin getPlugin() {
	return plugin;
}

}