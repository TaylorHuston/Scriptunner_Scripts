/*Set the default description content on new issues.
Add this code as the initializer for a Behaviour mapped to the project.*/

def desc = getFieldById("description")

def defaultValue = "Some default"

//Set if Description is empty
if (!underlyingIssue?.description) { 
    desc.setFormValue(defaultValue)
}