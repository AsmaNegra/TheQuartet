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

/* pages/forgot-password.html.twig */
class __TwigTemplate_7375ca1b87a3c19b784425ebed951ea4 extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/forgot-password.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/forgot-password.html.twig"));

        // line 1
        yield "<!doctype html>
<html lang=\"en\" dir=\"ltr\">

<head>
\t<meta charset=\"UTF-8\">
\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">
\t<title>Forgot Password - Geex Dashboard</title>

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
\t\t<div class=\"geex-content__authentication geex-content__authentication--forgot-password\">
\t\t\t<div class=\"geex-content__authentication__content\">
\t\t\t\t<div class=\"geex-content__authentication__content__wrapper\">
\t\t\t\t\t<div class=\"geex-content__authentication__content__logo\">
\t\t\t\t\t\t<a href=\"/index\">
\t\t\t\t\t\t\t<img class=\"logo-lite\" src=\"assets/img/logo-dark.png\" alt=\"logo\">
\t\t\t\t\t\t\t<img class=\"logo-dark\" src=\"assets/img/logo-lite.png\" alt=\"logo\">
\t\t\t\t\t\t</a>
\t\t\t\t\t</div>
\t\t\t\t\t<form id=\"signInForm\" class=\"geex-content__authentication__form\">
\t\t\t\t\t\t<h2 class=\"geex-content__authentication__title\">Forgot your password? 👋</h2>
\t\t\t\t\t\t<p class=\"geex-content__authentication__desc\">Please enter the email address associated with your account and We will email you a link to reset your password.</p>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-group\">
\t\t\t\t\t\t\t<label for=\"emailSignIn\">Email Address</label>
\t\t\t\t\t\t\t<input type=\"email\" id=\"emailSignIn\" name=\"emailSignIn\" placeholder=\"Enter Your Email\" required>
\t\t\t\t\t\t\t<i class=\"uil-envelope\"></i>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<button type=\"submit\" class=\"geex-content__authentication__form-submit\">Forget Password</button>
\t\t\t\t\t\t<a href=\"/signin\" class=\"geex-content__authentication__form-submit return-btn\">Back to Login</a>
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
        return "pages/forgot-password.html.twig";
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
\t<title>Forgot Password - Geex Dashboard</title>

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
\t\t<div class=\"geex-content__authentication geex-content__authentication--forgot-password\">
\t\t\t<div class=\"geex-content__authentication__content\">
\t\t\t\t<div class=\"geex-content__authentication__content__wrapper\">
\t\t\t\t\t<div class=\"geex-content__authentication__content__logo\">
\t\t\t\t\t\t<a href=\"/index\">
\t\t\t\t\t\t\t<img class=\"logo-lite\" src=\"assets/img/logo-dark.png\" alt=\"logo\">
\t\t\t\t\t\t\t<img class=\"logo-dark\" src=\"assets/img/logo-lite.png\" alt=\"logo\">
\t\t\t\t\t\t</a>
\t\t\t\t\t</div>
\t\t\t\t\t<form id=\"signInForm\" class=\"geex-content__authentication__form\">
\t\t\t\t\t\t<h2 class=\"geex-content__authentication__title\">Forgot your password? 👋</h2>
\t\t\t\t\t\t<p class=\"geex-content__authentication__desc\">Please enter the email address associated with your account and We will email you a link to reset your password.</p>
\t\t\t\t\t\t<div class=\"geex-content__authentication__form-group\">
\t\t\t\t\t\t\t<label for=\"emailSignIn\">Email Address</label>
\t\t\t\t\t\t\t<input type=\"email\" id=\"emailSignIn\" name=\"emailSignIn\" placeholder=\"Enter Your Email\" required>
\t\t\t\t\t\t\t<i class=\"uil-envelope\"></i>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<button type=\"submit\" class=\"geex-content__authentication__form-submit\">Forget Password</button>
\t\t\t\t\t\t<a href=\"/signin\" class=\"geex-content__authentication__form-submit return-btn\">Back to Login</a>
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

</html>", "pages/forgot-password.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\pages\\forgot-password.html.twig");
    }
}
