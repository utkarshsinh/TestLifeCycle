# UserServiceImplTest in Java

This documentation pertains to the UserServiceImplTest, which is a test class that verifies the operations of the UserService implementation, including creating, updating, finding, and deleting users.

## Test Methods

### setup()
This `@BeforeAll` annotated method performs the initial setup before all test cases. It initializes the UsersDatabase and UserService.

### cleanup() 
After all test cases have been executed, this `@AfterAll` annotated method performs some cleanup duties such as closing the database connection.

### testCreateUser_whenProvidedWithValidDetails_returnsUserId() 
This test verifies that a user can be succesfully created and returns a non-null User ID.

### testUpdateUser_whenProvidedWithValidDetails_returnsUpdatedUserDetails() 
This test ensures that a user's details can be updated successfully and that the returned details are correct.

### testGetUserDetails_whenProvidedWithValidUserId_returnsUserDetails()
This tests the functionality of fetching a user's details using their User ID.

### testDeleteUser_whenProvidedWithValidUserId_returnsUserDetails()
This ensures that a user can be deleted correctly, confirming that if the User ID is then searched for, null will be returned.


Disclaimer: Always ensure to follow the standard code style conventions.
