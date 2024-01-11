// const switchers = [...document.querySelectorAll('.switcher')]

// switchers.forEach(item => {
// 	item.addEventListener('click', function() {
// 		switchers.forEach(item => item.parentElement.classList.remove('is-active'))
// 		this.parentElement.classList.add('is-active')
// 	})
// })

const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('logIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});
const signupmsg = document.getElementById('signupmsg');
if (signupmsg.innerText != ""){
	signUpButton.click();
}