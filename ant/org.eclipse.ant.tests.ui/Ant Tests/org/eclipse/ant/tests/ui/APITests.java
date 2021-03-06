/*******************************************************************************
 * Copyright (c) 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.ant.tests.ui;

import org.eclipse.ant.tests.ui.testplugin.AbstractAntUITest;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.JavaCore;

public class APITests extends AbstractAntUITest {

	public APITests(String name) {
		super(name);
	}

	public void testCompareJavaVersions() throws CoreException {
		String vmver = "1.6"; //$NON-NLS-1$
		int comparison = JavaCore.compareJavaVersions(vmver, JavaCore.VERSION_1_7);
		assertEquals("VM less than 1.7 version: ", -1, comparison); //$NON-NLS-1$

		vmver = "1.7"; //$NON-NLS-1$
		comparison = JavaCore.compareJavaVersions(vmver, JavaCore.VERSION_1_7);
		assertEquals("VM equal to 1.7: ", 0, comparison); //$NON-NLS-1$

		vmver = "1.8"; //$NON-NLS-1$
		comparison = JavaCore.compareJavaVersions(vmver, JavaCore.VERSION_1_7);
		assertEquals("VM more than 1.7: ", 1, comparison); //$NON-NLS-1$

	}

}