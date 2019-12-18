import com.atlassian.jira.bc.issue.IssueService
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.IssueInputParameters
import com.atlassian.jira.user.ApplicationUser

IssueService issueService = ComponentAccessor.getIssueService();
IssueInputParameters issueInputParameters = issueService.newIssueInputParameters();

def issueTypeID = "10001";  //ID of Story Issue Type

//The data to build the issue with
issueInputParameters
 .setProjectId(issue.getProjectObject().getId())
 .setSummary( "Test Summary" )
 .setDescription("test desc")
 .setIssueTypeId(issueTypeID)
 .setReporterId(issue.reporterId)
 .setAssigneeId(issue.assigneeId);

ApplicationUser user = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();

IssueService.CreateValidationResult createValidationResult = issueService.validateCreate(user, issueInputParameters); //Validates all the parameters

if (createValidationResult.isValid()) {
 IssueService.IssueResult createResult = issueService.create(user, createValidationResult);
}

