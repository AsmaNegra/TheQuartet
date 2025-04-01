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

/* pages/maintenance.html.twig */
class __TwigTemplate_d8e876ff59e2571f22e61e187ddcd143 extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/maintenance.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/maintenance.html.twig"));

        // line 1
        yield "<!doctype html>
<html lang=\"en\" dir=\"ltr\">

<head>
\t<meta charset=\"UTF-8\">
\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">
\t<title>Maintenance - Geex Dashboard</title>

\t<link href=\"https://fonts.googleapis.com/css2?family=Jost:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">

\t<!-- inject:css-->
\t<link rel=\"stylesheet\" href=\"./assets/vendor/css/bootstrap/bootstrap.css\">
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

<body class=\"geex-dashboard\">
\t
    ";
        // line 30
        yield from $this->loadTemplate("./partials/header.html.twig", "pages/maintenance.html.twig", 30)->unwrap()->yield($context);
        yield " 


    <main class=\"geex-main-content\">
\t\t
        ";
        // line 35
        yield from $this->loadTemplate("./partials/sidebar.html.twig", "pages/maintenance.html.twig", 35)->unwrap()->yield($context);
        yield "  

\t
        ";
        // line 38
        yield from $this->loadTemplate("./partials/customizer.html.twig", "pages/maintenance.html.twig", 38)->unwrap()->yield($context);
        yield "  

\t\t<div class=\"geex-content\">
\t\t\t<div class=\"geex-content__section geex-content__error\">
\t\t\t\t<div class=\"geex-content__error__wrapper\">
\t\t\t\t\t<div class=\"geex-content__error__content\">
\t\t\t\t\t\t<img src=\"./assets/img/maintanence.svg\" alt=\"Maintanence Image\">
\t\t\t\t\t\t<h3 class=\"geex-content__error__subtitle secondary\">Site Under Maintenance</h3>     
\t\t\t\t\t\t<p class=\"geex-content__error__desc\">We should be back shortly. Thank you for your patience.</p>
\t\t\t\t\t</div><!-- .page-content -->
\t\t\t\t</div>
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
        return "pages/maintenance.html.twig";
    }

    /**
     * @codeCoverageIgnore
     */
    public function isTraitable(): bool
    {
        return false;
    }

    /**
     * @codeCoverageIgnore
     */
    public function getDebugInfo(): array
    {
        return array (  93 => 38,  87 => 35,  79 => 30,  48 => 1,);
    }

    public function getSourceContext(): Source
    {
        return new Source("<!doctype html>
<html lang=\"en\" dir=\"ltr\">

<head>
\t<meta charset=\"UTF-8\">
\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">
\t<title>Maintenance - Geex Dashboard</title>

\t<link href=\"https://fonts.googleapis.com/css2?family=Jost:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">

\t<!-- inject:css-->
\t<link rel=\"stylesheet\" href=\"./assets/vendor/css/bootstrap/bootstrap.css\">
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

<body class=\"geex-dashboard\">
\t
    {% include \"./partials/header.html.twig\" %} 


    <main class=\"geex-main-content\">
\t\t
        {% include \"./partials/sidebar.html.twig\" %}  

\t
        {% include \"./partials/customizer.html.twig\" %}  

\t\t<div class=\"geex-content\">
\t\t\t<div class=\"geex-content__section geex-content__error\">
\t\t\t\t<div class=\"geex-content__error__wrapper\">
\t\t\t\t\t<div class=\"geex-content__error__content\">
\t\t\t\t\t\t<img src=\"./assets/img/maintanence.svg\" alt=\"Maintanence Image\">
\t\t\t\t\t\t<h3 class=\"geex-content__error__subtitle secondary\">Site Under Maintenance</h3>     
\t\t\t\t\t\t<p class=\"geex-content__error__desc\">We should be back shortly. Thank you for your patience.</p>
\t\t\t\t\t</div><!-- .page-content -->
\t\t\t\t</div>
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

</html>", "pages/maintenance.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\pages\\maintenance.html.twig");
    }
}
