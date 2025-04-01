<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Extension\CoreExtension;
use Twig\Extension\SandboxExtension;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;
use Twig\TemplateWrapper;

/* pages/signup.html.twig */
class __TwigTemplate_4d850f4a034ce014161949f1f6c05873 extends Template
{
    private Source $source;
    /**
     * @var array<string, Template>
     */
    private array $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
        ];
    }

    protected function doDisplay(array $context, array $blocks = []): iterable
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/signup.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/signup.html.twig"));

        // line 1
        yield "<!doctype html>
<html lang=\"en\" dir=\"ltr\">

<head>
\t<meta charset=\"UTF-8\">
\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">
\t<title>SignUp - Geex Dashboard</title>

\t<link href=\"https://fonts.googleapis.com/css2?family=Jost:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">

\t<!-- inject:css-->
\t<link rel=\"stylesheet\" href=\"./assets/vendor/css/bootstrap/bootstrap.css\">
    <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\">
\t<link rel=\"stylesheet\" href=\"assets/css/style.css\">
\t<!-- endinject -->
\t<link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"assets/img/favicon.svg\">
\t<!-- Fonts -->
\t<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/@iconscout/unicons@4.0.8/css/line.min.css\">
\t
    <script>
\t\t// Render localStorage JS:
\t\tif (localStorage.theme) document.documentElement.setAttribute(\"data-theme\", localStorage.theme);
\t\tif (localStorage.layout) document.documentElement.setAttribute(\"data-nav\", localStorage.navbar);
\t\tif (localStorage.layout) document.documentElement.setAttribute(\"dir\", localStorage.layout);
    </script>\t
</head>

<body class=\"geex-dashboard authentication-page\">
\t<main class=\"geex-content\">
\t\t<div class=\"geex-content__authentication\">
\t\t\t<div class=\"geex-content__authentication__content\">
\t\t\t\t<div class=\"geex-content__authentication__content__wrapper\">
\t\t\t\t\t<div class=\"geex-content__authentication__content__logo\">
\t\t\t\t\t\t<a href=\"/index\">
\t\t\t\t\t\t\t<img class=\"logo-lite\" src=\"assets/img/logo-dark.png\" alt=\"logo\">
\t\t\t\t\t\t\t<img class=\"logo-dark\" src=\"assets/img/logo-lite.png\" alt=\"logo\">
\t\t\t\t\t\t</a>
\t\t\t\t\t</div>
\t\t\t\t\t<form id=\"signInForm\" class=\"geex-content__authentication__form\">
\t\t\t\t\t\t<h2 class=\"geex-content__authentication__title\">Sing Up Your Account 👋</h2>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-group\">
\t\t\t\t\t\t\t<label for=\"emailSignIn\">Your Email</label>
\t\t\t\t\t\t\t<input type=\"email\" id=\"emailSignIn\" name=\"emailSignIn\" placeholder=\"Enter Your Email\" required>
\t\t\t\t\t\t\t<i class=\"uil-envelope\"></i>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-group\">
\t\t\t\t\t\t\t<div class=\"geex-content__authentication__label-wrapper\">
\t\t\t\t\t\t\t\t<label for=\"loginPassword\">Password</label>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<input type=\"password\" id=\"loginPassword\" name=\"loginPassword\" placeholder=\"Password\" required>
\t\t\t\t\t\t\t<i class=\"uil-eye toggle-password-type\"></i>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-group\">
\t\t\t\t\t\t\t<div class=\"geex-content__authentication__label-wrapper\">
\t\t\t\t\t\t\t\t<label for=\"loginPassword1\">Confirm Password</label>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<input type=\"password\" id=\"loginPassword1\" name=\"loginPassword1\" placeholder=\"Password\" required>
\t\t\t\t\t\t\t<i class=\"uil-eye toggle-password-type\"></i>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-group custom-checkbox\">
\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"geex-content__authentication__checkbox-input\" id=\"rememberMe\">
\t\t\t\t\t\t\t<label class=\"geex-content__authentication__checkbox-label\" for=\"rememberMe\">By creating a account you agree to Our <a href=\"#\">terms & conditions Privacy Policy</a></label>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<button type=\"submit\" class=\"geex-content__authentication__form-submit\">Sign Up</button>
\t\t\t\t\t\t<span class=\"geex-content__authentication__form-separator\">Or</span>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-social\">
\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__authentication__form-social__single\">
\t\t\t\t\t\t\t\t<img src=\"./assets/img/icon/google.svg\" alt=\"\">Google
\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__authentication__form-social__single\">
\t\t\t\t\t\t\t\t<svg width=\"15\" height=\"19\" viewBox=\"0 0 15 19\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t\t\t<path d=\"M10.9133 0H11.0427C11.1465 1.2826 10.6569 2.24096 10.062 2.93497C9.47815 3.62419 8.67872 4.29264 7.38574 4.19122C7.29949 2.92698 7.78985 2.0397 8.38403 1.34729C8.93508 0.701997 9.94535 0.127781 10.9133 0ZM14.8274 13.3499V13.3859C14.464 14.4864 13.9457 15.4296 13.3132 16.3048C12.7358 17.0995 12.0282 18.1689 10.7647 18.1689C9.67302 18.1689 8.94786 17.4669 7.82898 17.4477C6.64541 17.4285 5.99452 18.0347 4.91238 18.1872H4.54341C3.74877 18.0722 3.10747 17.4429 2.64027 16.8759C1.26264 15.2003 0.19806 13.0361 0 10.2664V9.4526C0.0838563 7.47039 1.04701 5.85876 2.32721 5.0777C3.00285 4.66241 3.93166 4.30861 4.96589 4.46674C5.40913 4.53543 5.86195 4.68717 6.25887 4.83731C6.63503 4.98186 7.10542 5.23822 7.55106 5.22464C7.85294 5.21586 8.15322 5.05853 8.4575 4.94752C9.34877 4.62567 10.2225 4.2567 11.3741 4.43001C12.7581 4.63925 13.7404 5.25419 14.3474 6.20297C13.1766 6.94809 12.251 8.07096 12.4091 9.98848C12.5497 11.7303 13.5624 12.7493 14.8274 13.3499Z\" fill=\"black\"/>
\t\t\t\t\t\t\t\t</svg>
\t\t\t\t\t\t\t\tApple
\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-footer\">
\t\t\t\t\t\t\talready have an account? <a href=\"/signin\">Sign In</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t</form>
\t\t\t\t</div>
\t\t\t</div>\t
\t\t\t<div class=\"geex-content__authentication__img\">
\t\t\t\t<img src=\"./assets/img/authentication.svg\" alt=\"\">
\t\t\t</div>
\t\t</div>
\t</main>

\t<!-- inject:js-->
\t<script src=\"./assets/vendor/js/jquery/jquery-3.5.1.min.js\"></script>
\t<script src=\"./assets/vendor/js/jquery/jquery-ui.js\"></script>
\t<script src=\"./assets/vendor/js/bootstrap/bootstrap.min.js\"></script>
\t<script src=\"./assets/js/main.js\"></script>
\t<!-- endinject-->
</body>

</html>";
        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        yield from [];
    }

    /**
     * @codeCoverageIgnore
     */
    public function getTemplateName(): string
    {
        return "pages/signup.html.twig";
    }

    /**
     * @codeCoverageIgnore
     */
    public function getDebugInfo(): array
    {
        return array (  48 => 1,);
    }

    public function getSourceContext(): Source
    {
        return new Source("<!doctype html>
<html lang=\"en\" dir=\"ltr\">

<head>
\t<meta charset=\"UTF-8\">
\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">
\t<title>SignUp - Geex Dashboard</title>

\t<link href=\"https://fonts.googleapis.com/css2?family=Jost:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">

\t<!-- inject:css-->
\t<link rel=\"stylesheet\" href=\"./assets/vendor/css/bootstrap/bootstrap.css\">
    <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\">
\t<link rel=\"stylesheet\" href=\"assets/css/style.css\">
\t<!-- endinject -->
\t<link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"assets/img/favicon.svg\">
\t<!-- Fonts -->
\t<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/@iconscout/unicons@4.0.8/css/line.min.css\">
\t
    <script>
\t\t// Render localStorage JS:
\t\tif (localStorage.theme) document.documentElement.setAttribute(\"data-theme\", localStorage.theme);
\t\tif (localStorage.layout) document.documentElement.setAttribute(\"data-nav\", localStorage.navbar);
\t\tif (localStorage.layout) document.documentElement.setAttribute(\"dir\", localStorage.layout);
    </script>\t
</head>

<body class=\"geex-dashboard authentication-page\">
\t<main class=\"geex-content\">
\t\t<div class=\"geex-content__authentication\">
\t\t\t<div class=\"geex-content__authentication__content\">
\t\t\t\t<div class=\"geex-content__authentication__content__wrapper\">
\t\t\t\t\t<div class=\"geex-content__authentication__content__logo\">
\t\t\t\t\t\t<a href=\"/index\">
\t\t\t\t\t\t\t<img class=\"logo-lite\" src=\"assets/img/logo-dark.png\" alt=\"logo\">
\t\t\t\t\t\t\t<img class=\"logo-dark\" src=\"assets/img/logo-lite.png\" alt=\"logo\">
\t\t\t\t\t\t</a>
\t\t\t\t\t</div>
\t\t\t\t\t<form id=\"signInForm\" class=\"geex-content__authentication__form\">
\t\t\t\t\t\t<h2 class=\"geex-content__authentication__title\">Sing Up Your Account 👋</h2>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-group\">
\t\t\t\t\t\t\t<label for=\"emailSignIn\">Your Email</label>
\t\t\t\t\t\t\t<input type=\"email\" id=\"emailSignIn\" name=\"emailSignIn\" placeholder=\"Enter Your Email\" required>
\t\t\t\t\t\t\t<i class=\"uil-envelope\"></i>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-group\">
\t\t\t\t\t\t\t<div class=\"geex-content__authentication__label-wrapper\">
\t\t\t\t\t\t\t\t<label for=\"loginPassword\">Password</label>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<input type=\"password\" id=\"loginPassword\" name=\"loginPassword\" placeholder=\"Password\" required>
\t\t\t\t\t\t\t<i class=\"uil-eye toggle-password-type\"></i>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-group\">
\t\t\t\t\t\t\t<div class=\"geex-content__authentication__label-wrapper\">
\t\t\t\t\t\t\t\t<label for=\"loginPassword1\">Confirm Password</label>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<input type=\"password\" id=\"loginPassword1\" name=\"loginPassword1\" placeholder=\"Password\" required>
\t\t\t\t\t\t\t<i class=\"uil-eye toggle-password-type\"></i>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-group custom-checkbox\">
\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"geex-content__authentication__checkbox-input\" id=\"rememberMe\">
\t\t\t\t\t\t\t<label class=\"geex-content__authentication__checkbox-label\" for=\"rememberMe\">By creating a account you agree to Our <a href=\"#\">terms & conditions Privacy Policy</a></label>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<button type=\"submit\" class=\"geex-content__authentication__form-submit\">Sign Up</button>
\t\t\t\t\t\t<span class=\"geex-content__authentication__form-separator\">Or</span>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-social\">
\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__authentication__form-social__single\">
\t\t\t\t\t\t\t\t<img src=\"./assets/img/icon/google.svg\" alt=\"\">Google
\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__authentication__form-social__single\">
\t\t\t\t\t\t\t\t<svg width=\"15\" height=\"19\" viewBox=\"0 0 15 19\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t\t\t<path d=\"M10.9133 0H11.0427C11.1465 1.2826 10.6569 2.24096 10.062 2.93497C9.47815 3.62419 8.67872 4.29264 7.38574 4.19122C7.29949 2.92698 7.78985 2.0397 8.38403 1.34729C8.93508 0.701997 9.94535 0.127781 10.9133 0ZM14.8274 13.3499V13.3859C14.464 14.4864 13.9457 15.4296 13.3132 16.3048C12.7358 17.0995 12.0282 18.1689 10.7647 18.1689C9.67302 18.1689 8.94786 17.4669 7.82898 17.4477C6.64541 17.4285 5.99452 18.0347 4.91238 18.1872H4.54341C3.74877 18.0722 3.10747 17.4429 2.64027 16.8759C1.26264 15.2003 0.19806 13.0361 0 10.2664V9.4526C0.0838563 7.47039 1.04701 5.85876 2.32721 5.0777C3.00285 4.66241 3.93166 4.30861 4.96589 4.46674C5.40913 4.53543 5.86195 4.68717 6.25887 4.83731C6.63503 4.98186 7.10542 5.23822 7.55106 5.22464C7.85294 5.21586 8.15322 5.05853 8.4575 4.94752C9.34877 4.62567 10.2225 4.2567 11.3741 4.43001C12.7581 4.63925 13.7404 5.25419 14.3474 6.20297C13.1766 6.94809 12.251 8.07096 12.4091 9.98848C12.5497 11.7303 13.5624 12.7493 14.8274 13.3499Z\" fill=\"black\"/>
\t\t\t\t\t\t\t\t</svg>
\t\t\t\t\t\t\t\tApple
\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-footer\">
\t\t\t\t\t\t\talready have an account? <a href=\"/signin\">Sign In</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t</form>
\t\t\t\t</div>
\t\t\t</div>\t
\t\t\t<div class=\"geex-content__authentication__img\">
\t\t\t\t<img src=\"./assets/img/authentication.svg\" alt=\"\">
\t\t\t</div>
\t\t</div>
\t</main>

\t<!-- inject:js-->
\t<script src=\"./assets/vendor/js/jquery/jquery-3.5.1.min.js\"></script>
\t<script src=\"./assets/vendor/js/jquery/jquery-ui.js\"></script>
\t<script src=\"./assets/vendor/js/bootstrap/bootstrap.min.js\"></script>
\t<script src=\"./assets/js/main.js\"></script>
\t<!-- endinject-->
</body>

</html>", "pages/signup.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\pages\\signup.html.twig");
    }
}
