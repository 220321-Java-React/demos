//Hopefully you all remember how Java Interfaces work :)
//TS interfaces are pretty much the same, but we usually store just object, no functions

//we'll make a UserComponent that inherits from this interface
export interface IUser {
    firstName: string,
    lastName: string,
    username: string,
    email: string
}
