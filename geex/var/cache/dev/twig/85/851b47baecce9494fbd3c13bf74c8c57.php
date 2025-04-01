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

/* base.html.twig */
class __TwigTemplate_c25d8f4d260e6744c98cfa7186f9a946 extends Template
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
            'title' => [$this, 'block_title'],
            'stylesheets' => [$this, 'block_stylesheets'],
            'mainHeader' => [$this, 'block_mainHeader'],
            'content' => [$this, 'block_content'],
            'body' => [$this, 'block_body'],
            'javascripts' => [$this, 'block_javascripts'],
        ];
    }

    protected function doDisplay(array $context, array $blocks = []): iterable
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "base.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "base.html.twig"));

        // line 1
        yield "<!DOCTYPE html>
<html lang=\"en\" dir=\"ltr\">
    <head>
        <meta charset=\"UTF-8\">
        <title>";
        // line 5
        yield from $this->unwrap()->yieldBlock('title', $context, $blocks);
        yield "</title>
        <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"";
        // line 6
        yield $this->env->getRuntime('Twig\Runtime\EscaperRuntime')->escape($this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/img/favicon.svg"), "html", null, true);
        yield "\">
        ";
        // line 7
        yield from $this->unwrap()->yieldBlock('stylesheets', $context, $blocks);
        // line 30
        yield "
    </head>
    <body class=\"geex-dashboard\">

         ";
        // line 34
        yield from $this->loadTemplate("./partials/header.html.twig", "base.html.twig", 34)->unwrap()->yield($context);
        yield "    
         
        <main class=\"geex-main-content\">
             
            ";
        // line 38
        yield from $this->loadTemplate("./partials/sidebar.html.twig", "base.html.twig", 38)->unwrap()->yield($context);
        yield "    
             
            ";
        // line 40
        yield from $this->loadTemplate("./partials/customizer.html.twig", "base.html.twig", 40)->unwrap()->yield($context);
        yield "    
            
            <div class=\"geex-content\">
                
                <div class=\"geex-content__header\">
                    <div class=\"geex-content__header__content\">
                        <h2 class=\"geex-content__header__title\">";
        // line 46
        yield from $this->unwrap()->yieldBlock('mainHeader', $context, $blocks);
        yield "</h2>
                        <p class=\"geex-content__header__subtitle\">";
        // line 47
        yield from $this->unwrap()->yieldBlock('content', $context, $blocks);
        yield "</p>
                    </div>
                    
                    ";
        // line 50
        yield from $this->loadTemplate("./partials/contentHeader.html.twig", "base.html.twig", 50)->unwrap()->yield($context);
        yield "    
                   
                </div>
                    
                ";
        // line 54
        yield from $this->unwrap()->yieldBlock('body', $context, $blocks);
        // line 55
        yield "            </div>
        </main>

        ";
        // line 58
        yield from $this->unwrap()->yieldBlock('javascripts', $context, $blocks);
        // line 72
        yield "    </body>
</html>
";
        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        yield from [];
    }

    // line 5
    /**
     * @return iterable<null|scalar|\Stringable>
     */
    public function block_title(array $context, array $blocks = []): iterable
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        yield from [];
    }

    // line 7
    /**
     * @return iterable<null|scalar|\Stringable>
     */
    public function block_stylesheets(array $context, array $blocks = []): iterable
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "stylesheets"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "stylesheets"));

        // line 8
        yield "        
        
        <link href=\"https://fonts.googleapis.com/css2?family=Jost:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">

        <!-- inject:css-->
        <link rel=\"stylesheet\" href=\"";
        // line 13
        yield $this->env->getRuntime('Twig\Runtime\EscaperRuntime')->escape($this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/vendor/css/bootstrap/bootstrap.css"), "html", null, true);
        yield "\">
        <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\">
        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/apexcharts@3.27.0/dist/apexcharts.min.css\">
        <link rel=\"stylesheet\" href=\"";
        // line 16
        yield $this->env->getRuntime('Twig\Runtime\EscaperRuntime')->escape($this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/css/style.css"), "html", null, true);
        yield "\">
        <!-- endinject -->
      
        <!-- Fonts -->
        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/@iconscout/unicons@4.0.8/css/line.min.css\">
        
        <script>
            // Render localStorage JS:
            if (localStorage.theme) document.documentElement.setAttribute(\"data-theme\", localStorage.theme);
            if (localStorage.layout) document.documentElement.setAttribute(\"data-nav\", localStorage.navbar);
            if (localStorage.layout) document.documentElement.setAttribute(\"dir\", localStorage.layout);
        </script>\t
        
        ";
        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        yield from [];
    }

    // line 46
    /**
     * @return iterable<null|scalar|\Stringable>
     */
    public function block_mainHeader(array $context, array $blocks = []): iterable
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "mainHeader"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "mainHeader"));

        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        yield from [];
    }

    // line 47
    /**
     * @return iterable<null|scalar|\Stringable>
     */
    public function block_content(array $context, array $blocks = []): iterable
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "content"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "content"));

        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        yield from [];
    }

    // line 54
    /**
     * @return iterable<null|scalar|\Stringable>
     */
    public function block_body(array $context, array $blocks = []): iterable
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        yield from [];
    }

    // line 58
    /**
     * @return iterable<null|scalar|\Stringable>
     */
    public function block_javascripts(array $context, array $blocks = []): iterable
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "javascripts"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "javascripts"));

        // line 59
        yield "        <!-- inject:js-->
        <script src=\"";
        // line 60
        yield $this->env->getRuntime('Twig\Runtime\EscaperRuntime')->escape($this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/vendor/js/jquery/jquery-3.5.1.min.js"), "html", null, true);
        yield "\"></script>
        <script src=\"";
        // line 61
        yield $this->env->getRuntime('Twig\Runtime\EscaperRuntime')->escape($this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/vendor/js/jquery/jquery-ui.js"), "html", null, true);
        yield "\"></script>
        <script src=\"";
        // line 62
        yield $this->env->getRuntime('Twig\Runtime\EscaperRuntime')->escape($this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/vendor/js/bootstrap/bootstrap.min.js"), "html", null, true);
        yield "\"></script>

        <script src=\"https://fullcalendar.io/releases/fullcalendar/3.9.0/lib/moment.min.js\"></script>
        <script src=\"https://fullcalendar.io/releases/fullcalendar/3.9.0/fullcalendar.min.js\"></script>

        <script src=\"https://unpkg.com/swiper/swiper-bundle.min.js\"></script>
        <script src=\"https://cdn.jsdelivr.net/npm/apexcharts@3.27.0/dist/apexcharts.min.js\"></script>
        <script src=\"";
        // line 69
        yield $this->env->getRuntime('Twig\Runtime\EscaperRuntime')->escape($this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("assets/js/main.js"), "html", null, true);
        yield "\"></script>
        <!-- endinject-->
        ";
        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        yield from [];
    }

    /**
     * @codeCoverageIgnore
     */
    public function getTemplateName(): string
    {
        return "base.html.twig";
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
        return array (  309 => 69,  299 => 62,  295 => 61,  291 => 60,  288 => 59,  275 => 58,  253 => 54,  231 => 47,  209 => 46,  184 => 16,  178 => 13,  171 => 8,  158 => 7,  136 => 5,  123 => 72,  121 => 58,  116 => 55,  114 => 54,  107 => 50,  101 => 47,  97 => 46,  88 => 40,  83 => 38,  76 => 34,  70 => 30,  68 => 7,  64 => 6,  60 => 5,  54 => 1,);
    }

    public function getSourceContext(): Source
    {
        return new Source("<!DOCTYPE html>
<html lang=\"en\" dir=\"ltr\">
    <head>
        <meta charset=\"UTF-8\">
        <title>{% block title %}{% endblock %}</title>
        <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"{{asset('assets/img/favicon.svg')}}\">
        {% block stylesheets %}
        
        
        <link href=\"https://fonts.googleapis.com/css2?family=Jost:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">

        <!-- inject:css-->
        <link rel=\"stylesheet\" href=\"{{asset('assets/vendor/css/bootstrap/bootstrap.css')}}\">
        <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\">
        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/apexcharts@3.27.0/dist/apexcharts.min.css\">
        <link rel=\"stylesheet\" href=\"{{asset('assets/css/style.css')}}\">
        <!-- endinject -->
      
        <!-- Fonts -->
        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/@iconscout/unicons@4.0.8/css/line.min.css\">
        
        <script>
            // Render localStorage JS:
            if (localStorage.theme) document.documentElement.setAttribute(\"data-theme\", localStorage.theme);
            if (localStorage.layout) document.documentElement.setAttribute(\"data-nav\", localStorage.navbar);
            if (localStorage.layout) document.documentElement.setAttribute(\"dir\", localStorage.layout);
        </script>\t
        
        {% endblock %}

    </head>
    <body class=\"geex-dashboard\">

         {% include \"./partials/header.html.twig\" %}    
         
        <main class=\"geex-main-content\">
             
            {% include \"./partials/sidebar.html.twig\" %}    
             
            {% include \"./partials/customizer.html.twig\" %}    
            
            <div class=\"geex-content\">
                
                <div class=\"geex-content__header\">
                    <div class=\"geex-content__header__content\">
                        <h2 class=\"geex-content__header__title\">{% block mainHeader %}{% endblock %}</h2>
                        <p class=\"geex-content__header__subtitle\">{% block content %}{% endblock %}</p>
                    </div>
                    
                    {% include \"./partials/contentHeader.html.twig\" %}    
                   
                </div>
                    
                {% block body %}{% endblock %}
            </div>
        </main>

        {% block javascripts %}
        <!-- inject:js-->
        <script src=\"{{asset('assets/vendor/js/jquery/jquery-3.5.1.min.js')}}\"></script>
        <script src=\"{{asset('assets/vendor/js/jquery/jquery-ui.js')}}\"></script>
        <script src=\"{{asset('assets/vendor/js/bootstrap/bootstrap.min.js')}}\"></script>

        <script src=\"https://fullcalendar.io/releases/fullcalendar/3.9.0/lib/moment.min.js\"></script>
        <script src=\"https://fullcalendar.io/releases/fullcalendar/3.9.0/fullcalendar.min.js\"></script>

        <script src=\"https://unpkg.com/swiper/swiper-bundle.min.js\"></script>
        <script src=\"https://cdn.jsdelivr.net/npm/apexcharts@3.27.0/dist/apexcharts.min.js\"></script>
        <script src=\"{{asset('assets/js/main.js')}}\"></script>
        <!-- endinject-->
        {% endblock %}
    </body>
</html>
", "base.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\base.html.twig");
    }
}
