<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- CSS -->
    <link rel="stylesheet" href="assets/css/styles.css">

    <title>SideBar sub menus</title>
    <style>
    /* GOOGLE FONTS */
@import url("https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap");

/* VARIABLES CSS */
:root {
    --nav--width: 92px;

    /* Colores */
    --first-color: #0c5df4;
    --bg-color: #12192c;
    --sub-color: #b6cefc;
    --white-color: #fff;

    /* Fuente y tipografia */
    --body-font: 'Poppins', sans-serif;
    --normal-font-size: 1rem;
    --small-font-size: .875rem;

    /* z index */
    --z-fixed: 100;
}

/* BASE */
*, ::before, ::after {
    box-sizing: border-box;
}

body {
    position: relative;
    margin: 0;
    padding: 2rem 0 0 6.75rem;
    font-family: var(--body-font);
    font-size: var(--normal-font-size);
    transition: .5s;
}

h1 {
    margin: 0;
}

ul {
    margin: 0;
    padding: 0;
    list-style: none;
}

a {
    text-decoration: none;
}

/* l NAV */
.l-navbar {
    position: fixed;
    top: 0;
    left: 0;
    width: var(--nav--width);
    height: 100vh;
    background-color: var(--bg-color);
    color: var(--white-color);
    padding: 1.5rem 1.5rem 2rem;
    transition: .5s;
    z-index: var(--z-fixed);
}

/* NAV */
.nav {
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    overflow: hidden;
}

.nav__brand {
    display: grid;
    grid-template-columns: max-content max-content;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 2rem;
}

.nav__toggle {
    font-size: 1.25rem;
    padding: .75rem;
    cursor: pointer;
}

.nav__logo {
    color: var(--white-color);
    font-weight: 600;
}

.nav__link {
    display: grid;
    grid-template-columns: max-content max-content;
    align-items: center;
    column-gap: .75rem;
    padding: .75rem;
    color: var(--white-color);
    border-radius: .5rem;
    margin-bottom: 1rem;
    transition: .3s;
    cursor: pointer;
}

.nav__link:hover {
    background-color: var(--first-color);
}

.nav__icon {
    font-size: 1.25rem;
}

.nav_name {
    font-size: var(--small-font-size);
}

/* Expander menu */
.expander {
    width: calc(var(--nav--width) + 9.25rem);
}

/* Add padding body*/
.body-pd {
    padding: 2rem 0 0 16rem;
}

/* Active links menu */
.active {
    background-color: var(--first-color);
}

/* COLLAPSE */
.collapse {
    grid-template-columns: 20px max-content 1fr;
}

.collapse__link {
    justify-self: flex-end;
    transition: .5;
}

.collapse__menu {
    display: none;
    padding: .75rem 2.25rem;
}

.collapse__sublink {
    color: var(--sub-color);
    font-size: var(--small-font-size);
}

.collapse__sublink:hover {
    color: var(--white-color);
}

/* Show collapse */
.showCollapse {
    display: block;
}

/* Rotate icon */
.rotate {
    transform: rotate(180deg);
    transition: .5s;
}
    </style>
</head>
<body id="body-pd">
	
    <div class="l-navbar" id="navbar">
        <nav class="nav">
            <div>
                <div class="nav__brand">
                    <ion-icon name="menu-outline" class="nav__toggle" id="nav-toggle"></ion-icon>
                    <a href="memberMyPage.do" class="nav__logo">MyPage</a>
                </div>
                <div class="nav__list">
                    <a href="home.do" class="nav__link active">
                        <ion-icon name="home-outline" class="nav__icon"></ion-icon>
                        <span class="nav_name">Home</span>
                    </a>
                    <a href="openBanking.do" class="nav__link">
                        <ion-icon name="albums-outline" class="nav__icon"></ion-icon>
                        <span class="nav_name">Accounts</span>
                    </a>

                    <a href="noticeList.do" class="nav__link">
                        <ion-icon name="alert-circle-outline" class="nav__icon"></ion-icon>
                        <span class="nav_name">Notice</span>
                    </a>

                    <a href="qnaList.do" class="nav__link">
                        <ion-icon name="help-circle-outline" class="nav__icon"></ion-icon>
                        <span class="nav_name">QnA</span>
                    </a>

					<a href="mapAtm.do" class="nav__link">
                        <ion-icon name="locate-outline" class="nav__icon"></ion-icon>
                        <span class="nav_name">Bank</span>
                    </a>
                    <a href="memberUpdateForm.do" class="nav__link">
                        <ion-icon name="settings-outline" class="nav__icon"></ion-icon>
                        <span class="nav_name">Privacy</span>
                    </a>
                </div>
                <a href="memberLoginForm.do" class="nav__link">
                    <ion-icon name="log-out-outline" class="nav__icon"></ion-icon>
                    <span class="nav_name">Logout</span>
                </a>
            </div>
        </nav>
    </div>

    <!-- IONICONS -->
    <script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>
    <!-- JS -->
    <script src="assets/js/main.js"></script>
    
    <script type="text/javascript">
    /* EXPANDER MENU */

    const showMenu = (toggleId, navbarId, bodyId) => {
        const toggle = document.getElementById(toggleId),
        navbar = document.getElementById(navbarId),
        bodypadding = document.getElementById(bodyId)

        if( toggle && navbar ) {
            toggle.addEventListener('click', ()=>{
                navbar.classList.toggle('expander');

                bodypadding.classList.toggle('body-pd')
            })
        }
    }

    showMenu('nav-toggle', 'navbar', 'body-pd')

    /* LINK ACTIVE */
    const linkColor = document.querySelectorAll('.nav__link')
    function colorLink() {
        linkColor.forEach(l=> l.classList.remove('active'))
        this.classList.add('active')
    }
    linkColor.forEach(l=> l.addEventListener('click', colorLink))

    /* COLLAPSE MENU */
    const linkCollapse = document.getElementsByClassName('collapse__link')
    var i

    for(i=0;i<linkCollapse.length;i++) {
        linkCollapse[i].addEventListener('click', function(){
            const collapseMenu = this.nextElementSibling
            collapseMenu.classList.toggle('showCollapse')

            const rotate = collapseMenu.previousElementSibling
            rotate.classList.toggle('rotate')
        });
    }
    </script>
</body>
</html>
