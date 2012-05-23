package com.myonlinebd.catalog.client.accountcreation;

import com.google.gwt.user.client.ui.Widget;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public interface AccountCreatorWorkflowView {

  Widget asWidget();

  void setWorkflow(AccountCreatorWorkflow accountCreatorWorkflow);

  void disableSubmitButton();

  void showMessage(String violationMessages);

  void enableSubmitButton();

  void gotToSuccessPage();

  void gotToFailurePage();

  void clearNotificationMessage();
}
