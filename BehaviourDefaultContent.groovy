/*Set the default content on new issues.
Add this code as the initializer for a Behaviour mapped to the project.*/

import com.atlassian.jira.component.ComponentAccessor
import static com.atlassian.jira.issue.IssueFieldConstants.*


//Default Description
def desc = getFieldById("description")
def defaultValue = "Some default"

if (getActionName() != "Create Issue") {
    return // not the initial action, so don't set default values
}

//Set if Description is empty
if (!underlyingIssue?.description) { 
    desc.setFormValue(defaultValue)
}

//Components
def projectComponentManager = ComponentAccessor.getProjectComponentManager()
def components = projectComponentManager.findAllForProject(issueContext.projectObject.id)
getFieldById(COMPONENTS).setFormValue(components.findAll { it.name in ["Support Question", "Frontend"] }*.id)

//"Affects Versions" to the latest version
def versionManager = ComponentAccessor.getVersionManager()
def versions = versionManager.getVersions(issueContext.projectObject)
if (versions) {
    getFieldById(AFFECTED_VERSIONS).setFormValue([versions.last().id])
}

//Assignee
getFieldById(ASSIGNEE).setFormValue("Taylor Alexander Huston")