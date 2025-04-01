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

/* features/color.html.twig */
class __TwigTemplate_7470784068b9da56081c748dc9b98dfc extends Template
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

        $this->blocks = [
            'title' => [$this, 'block_title'],
            'mainHeader' => [$this, 'block_mainHeader'],
            'content' => [$this, 'block_content'],
            'body' => [$this, 'block_body'],
        ];
    }

    protected function doGetParent(array $context): bool|string|Template|TemplateWrapper
    {
        // line 1
        return "base.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = []): iterable
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "features/color.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "features/color.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "features/color.html.twig", 1);
        yield from $this->parent->unwrap()->yield($context, array_merge($this->blocks, $blocks));
        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

    }

    // line 3
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

        yield "Color - Geex Dashboard";
        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        yield from [];
    }

    // line 5
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

        yield "Color";
        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        yield from [];
    }

    // line 7
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

        yield "Form Elements is used to style and format the input field";
        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        yield from [];
    }

    // line 9
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

        // line 10
        yield "
<div class=\"geex-content__section geex-content__form\">
    <div class=\"geex-content__form__wrapper flex flex-column gap-20\">
        <h4 class=\"geex-content__form__title\">Theme Color</h4>
        <div class=\"geex-content__form__wrapper__item d-flex flex-wrap gap-30 mb-50\">
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Primary</h4>
                <div class=\"geex-content__form__color__box primary-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Secondary</h4>
                <div class=\"geex-content__form__color__box secondary-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Quatinery</h4>
                <div class=\"geex-content__form__color__box quatinery-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Tertiary</h4>
                <div class=\"geex-content__form__color__box tertiary-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Success</h4>
                <div class=\"geex-content__form__color__box success-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Danger</h4>
                <div class=\"geex-content__form__color__box danger-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Warning</h4>
                <div class=\"geex-content__form__color__box warning-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Info</h4>
                <div class=\"geex-content__form__color__box info-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Body</h4>
                <div class=\"geex-content__form__color__box body-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Dark</h4>
                <div class=\"geex-content__form__color__box dark-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Sec</h4>
                <div class=\"geex-content__form__color__box sec-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Grey 3</h4>
                <div class=\"geex-content__form__color__box grayThree-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Grey 2</h4>
                <div class=\"geex-content__form__color__box grayTwo-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Section</h4>
                <div class=\"geex-content__form__color__box section-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">White</h4>
                <div class=\"geex-content__form__color__box white-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Grey 1</h4>
                <div class=\"geex-content__form__color__box grayOne-bg\"></div>
            </div>
        </div>
        <h4 class=\"geex-content__form__title\">Theme Color</h4>
        <div class=\"geex-content__form__wrapper__item d-flex flex-wrap gap-30\">
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Primary</h4>
                <div class=\"geex-content__form__color__box transparent primary-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Secondary</h4>
                <div class=\"geex-content__form__color__box transparent secondary-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Quatinery</h4>
                <div class=\"geex-content__form__color__box transparent quatinery-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Tertiary</h4>
                <div class=\"geex-content__form__color__box transparent tertiary-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Success</h4>
                <div class=\"geex-content__form__color__box transparent success-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Danger</h4>
                <div class=\"geex-content__form__color__box transparent danger-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Warning</h4>
                <div class=\"geex-content__form__color__box transparent warning-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Info</h4>
                <div class=\"geex-content__form__color__box transparent info-bg\"></div>
            </div>
        </div>
    </div>
</div>

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
        return "features/color.html.twig";
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
        return array (  148 => 10,  135 => 9,  112 => 7,  89 => 5,  66 => 3,  43 => 1,);
    }

    public function getSourceContext(): Source
    {
        return new Source("{% extends 'base.html.twig' %}

{% block title %}Color - Geex Dashboard{% endblock %}

{% block mainHeader %}Color{% endblock %}

{% block content %}Form Elements is used to style and format the input field{% endblock %}

{% block body %}

<div class=\"geex-content__section geex-content__form\">
    <div class=\"geex-content__form__wrapper flex flex-column gap-20\">
        <h4 class=\"geex-content__form__title\">Theme Color</h4>
        <div class=\"geex-content__form__wrapper__item d-flex flex-wrap gap-30 mb-50\">
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Primary</h4>
                <div class=\"geex-content__form__color__box primary-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Secondary</h4>
                <div class=\"geex-content__form__color__box secondary-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Quatinery</h4>
                <div class=\"geex-content__form__color__box quatinery-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Tertiary</h4>
                <div class=\"geex-content__form__color__box tertiary-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Success</h4>
                <div class=\"geex-content__form__color__box success-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Danger</h4>
                <div class=\"geex-content__form__color__box danger-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Warning</h4>
                <div class=\"geex-content__form__color__box warning-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Info</h4>
                <div class=\"geex-content__form__color__box info-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Body</h4>
                <div class=\"geex-content__form__color__box body-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Dark</h4>
                <div class=\"geex-content__form__color__box dark-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Sec</h4>
                <div class=\"geex-content__form__color__box sec-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Grey 3</h4>
                <div class=\"geex-content__form__color__box grayThree-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Grey 2</h4>
                <div class=\"geex-content__form__color__box grayTwo-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Section</h4>
                <div class=\"geex-content__form__color__box section-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">White</h4>
                <div class=\"geex-content__form__color__box white-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Grey 1</h4>
                <div class=\"geex-content__form__color__box grayOne-bg\"></div>
            </div>
        </div>
        <h4 class=\"geex-content__form__title\">Theme Color</h4>
        <div class=\"geex-content__form__wrapper__item d-flex flex-wrap gap-30\">
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Primary</h4>
                <div class=\"geex-content__form__color__box transparent primary-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Secondary</h4>
                <div class=\"geex-content__form__color__box transparent secondary-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Quatinery</h4>
                <div class=\"geex-content__form__color__box transparent quatinery-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Tertiary</h4>
                <div class=\"geex-content__form__color__box transparent tertiary-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Success</h4>
                <div class=\"geex-content__form__color__box transparent success-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Danger</h4>
                <div class=\"geex-content__form__color__box transparent danger-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Warning</h4>
                <div class=\"geex-content__form__color__box transparent warning-bg\"></div>
            </div>
            <div class=\"geex-content__form__color\">
                <h4 class=\"geex-content__form__color__label\">Info</h4>
                <div class=\"geex-content__form__color__box transparent info-bg\"></div>
            </div>
        </div>
    </div>
</div>

{% endblock %}
", "features/color.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\features\\color.html.twig");
    }
}
