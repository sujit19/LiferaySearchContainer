package com.search;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.student.services.service.StudentLocalServiceUtil;

public class SearchContainer extends MVCPortlet {
	
	public void deleteStudent(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException {
		String backURL  = ParamUtil.getString(actionRequest, "backURL");
		int studentId = ParamUtil.getInteger(actionRequest, "studentId");
        try {
			StudentLocalServiceUtil.deleteStudent(studentId);
			System.out.println("Successfully Deleted Student of Id =>"+studentId);
			actionResponse.sendRedirect(backURL); 
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
      
  }
}
