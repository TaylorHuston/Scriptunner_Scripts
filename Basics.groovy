//How to display information to the log while troubleshooting


import org.apache.log4j.Logger
import org.apache.log4j.Level
  
def log = Logger.getLogger("com.acme.CreateSubtask")
log.setLevel(Level.DEBUG)
  
log.debug "foo bar"

