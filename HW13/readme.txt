Original Version:
The Database class in the original version has a race condition when multiple threads access the updateProfile method concurrently. 
In the Handler class, multiple threads create Database instances and call the updateProfile method. This leads to a race condition where
 multiple threads can interfere with each other while updating the user profiles in the shared userProfile map.

Revised Version:
In the revised version, the race condition is addressed using a ReentrantLock. 
Both the updateProfile and getProfile methods in the Database class are now guarded by a lock. 
This ensures that only one thread can update or retrieve a profile at a time, preventing race conditions and ensuring thread safety.

Additionally, the getInstance method, which provides a singleton instance of the Database, 
is protected by a separate lock (instanceLock) to avoid race conditions during the creation of the singleton instance.