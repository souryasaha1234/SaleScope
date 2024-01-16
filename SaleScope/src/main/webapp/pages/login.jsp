<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <title>LogIn & signUp</title>
        <head>
            <meta charset="UTF-8" />
            <title>Form</title>
            <!-- <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'> -->
            <link rel="stylesheet" href="styles/style.css" />
            <link rel="stylesheet" href="styles/loginStyle.css" />
        </head>
    </head>
    <body>
        <a href="homepage"
        id="logo"
            ><img
                src="resources/img/SaleScope-logos_transparent.png"
                height="150px"
        /></a>

        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form action="SignupServlet" method="POST">
                    <h1>Create Account</h1>
                    <span id="signupmsg">${messegeSignUp}</span>
                    
                    <input type="text" placeholder="Username" name="uname" value="${username }" required/>
                    <input type="email" placeholder="Email" name="uemail" value="${email }" required/>
                    <input type="password" placeholder="Password" name="upassword" value="${password }" required/>
                    <input type="password" placeholder="Confirm Password" name="cnfpassword" required/>
                    <button type="submit">Sign Up</button>
                </form>
            </div>
            <div class="form-container log-in-container">
                <form action="LoginServlet" method="POST">
                    <h1>Log in</h1>
                    <span>${messegeLogIn}</span>
                    
                    <input type="text" placeholder="Username" name="uname" value="${username }" required/>
                    <input type="email" placeholder="Email" name="uemail" value="${email }" required/>
                    <input type="password" placeholder="Password" name="upassword" value="${password }" required/>
                    <a href="#">Forgot your password?</a>
                    <button type="submit">Log In</button>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Welcome Back!</h1>
                        <p>
                            To keep connected with us please login with your
                            personal info
                        </p>
                        <button class="ghost" id="logIn">Log In</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Hello, User!</h1>
                        <p>
                            Enter your personal details and start journey with
                            us
                        </p>
                        <button class="ghost" id="signUp">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>
        <script src="scripts/script.js"></script>
    </body>
</html>
    