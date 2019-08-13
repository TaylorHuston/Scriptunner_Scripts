/*Select lsit with multiple options, if Other is selcted a text field appears.
This works if you've set up a Behaviour for the Select List Custom Field.
https://scriptrunner.adaptavist.com/latest/jira/behaviours-overview.html*/


import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.CustomFieldManager
import com.atlassian.jira.issue.fields.CustomField

def customFieldManager = ComponentAccessor.getCustomFieldManager();
def optionList = getFieldById(getFieldChanged());  //getFieldChanged() always returns the field ID of the field the behaviour fires for
def other = getFieldByName("Other");
other.setHidden(true); //Hides text field

def selectedOption = optionList.getValue() as String;

if (selectedOption == "Other") {
    other.setHidden(false);
    other.setRequired(true);
} else {
    other.setHidden(true);
    other.setRequired(false);
}