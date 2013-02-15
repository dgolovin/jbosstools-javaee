package org.jboss.tools.jsf.ui.test;

import java.lang.reflect.InvocationTargetException;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.IWorkbenchWindow;
import org.jboss.tools.common.model.ui.ModelUIPlugin;
import org.jboss.tools.common.model.ui.templates.configuration.MetaClassTemplateHelper;
import org.jboss.tools.common.model.ui.templates.configuration.MetaConfiguration;
import org.jboss.tools.jsf.ui.JsfUiPlugin;
import org.jboss.tools.jsf.ui.operation.JSFProjectCreationOperation;
import org.jboss.tools.jsf.web.helpers.context.NewProjectWizardContext;
import org.jboss.tools.test.util.ResourcesUtils;
import org.junit.Test;

public class MetaClassTemplateHelperTest extends TestCase {

	@Test
	public void testGetCurrentConfiguration() throws InvocationTargetException, InterruptedException, CoreException {
		try {
			
			NewProjectWizardContext context = new NewProjectWizardContext();
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("TemplatesTest");
			context.setProject(project);
			IPath defaultPath = ModelUIPlugin.getWorkspace().getRoot().getLocation();
			IPath locationPath = defaultPath.append("TemplatesTest");
			context.setServletVersion("2.5");
			context.setProjectLocation(locationPath.toOSString());
			context.setProjectTemplate("JSFKickStartWithoutLibs");
			context.setJSFVersion("JSF 2.0");
	
			JSFProjectCreationOperation operation = new JSFProjectCreationOperation(context);
			IWorkbenchWindow window = JsfUiPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow();
			window.run(false, false, operation);
			MetaConfiguration config = MetaClassTemplateHelper.instance.getCurrentConfiguration(project);
			assertNotNull(config);
			String className = MetaClassTemplateHelper.instance.getSuperClassName(project, 
					"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-facesconfig_2_0.xsd", 
					"application-factory/text()[1]");
			System.out.println(className);
			assertNotNull(className);
			
		} finally {
			ResourcesUtils.deleteProject("TemplatesTest");
		}
	}
}
