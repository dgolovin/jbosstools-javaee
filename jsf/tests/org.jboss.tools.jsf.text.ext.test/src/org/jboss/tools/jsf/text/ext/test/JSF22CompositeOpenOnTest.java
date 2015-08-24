/******************************************************************************* 
 * Copyright (c) 2014 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/
package org.jboss.tools.jsf.text.ext.test;

public class JSF22CompositeOpenOnTest extends JSF2CompositeOpenOnTest {

	@Override
	protected String getProjectName() {
		return "JSF22CompositeOpenOn";
	}

	@Override
	protected String getTaglibName() {
		return "html_basic.taglib.xml";
	}
}