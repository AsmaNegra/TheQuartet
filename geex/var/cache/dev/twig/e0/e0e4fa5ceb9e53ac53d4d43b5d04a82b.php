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

/* features/icon.html.twig */
class __TwigTemplate_2c9350b4e80556bbf43e4ce2de621493 extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "features/icon.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "features/icon.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "features/icon.html.twig", 1);
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

        yield "Icons - Geex Dashboard";
        
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

        yield "Icons";
        
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
<div class=\"geex-content__section geex-content__icon\">
    <div class=\"geex-content__icon__wrapper\">
        <i class=\"uil-0-plus\"></i>
        <i class=\"uil-16-plus\"></i>
        <i class=\"uil-3-plus\"></i>
        <i class=\"uil-accessible-icon-alt\"></i>
        <i class=\"uil-adjust\"></i>
        <i class=\"uil-align-alt\"></i>
        <i class=\"uil-align-center-v\"></i>
        <i class=\"uil-align-left\"></i>
        <i class=\"uil-align\"></i>
        <i class=\"uil-analytics\"></i>
        <i class=\"uil-android\"></i>
        <i class=\"uil-angle-double-up\"></i>
        <i class=\"uil-angle-right\"></i>
        <i class=\"uil-annoyed-alt\"></i>
        <i class=\"uil-apps\"></i>
        <i class=\"uil-arrow-break\"></i>
        <i class=\"uil-arrow-circle-up\"></i>
        <i class=\"uil-arrow-down\"></i>
        <i class=\"uil-arrow-left\"></i>
        <i class=\"uil-arrow-to-bottom\"></i>
        <i class=\"uil-arrow-up\"></i>
        <i class=\"uil-arrows-maximize\"></i>
        <i class=\"uil-arrows-resize\"></i>
        <i class=\"uil-arrows-up-right\"></i>
        <i class=\"uil-asterisk\"></i>
        <i class=\"uil-auto-flash\"></i>
        <i class=\"uil-backpack\"></i>
        <i class=\"uil-bag-slash\"></i>
        <i class=\"uil-ban\"></i>
        <i class=\"uil-basketball\"></i>
        <i class=\"uil-bed-double\"></i>
        <i class=\"uil-bell-school\"></i>
        <i class=\"uil-bitcoin-alt\"></i>
        <i class=\"uil-black-berry\"></i>
        <i class=\"uil-bold\"></i>
        <i class=\"uil-book-alt\"></i>
        <i class=\"uil-book\"></i>
        <i class=\"uil-boombox\"></i>
        <i class=\"uil-border-horizontal\"></i>
        <i class=\"uil-border-right\"></i>
        <i class=\"uil-box\"></i>
        <i class=\"uil-brightness-empty\"></i>
        <i class=\"uil-brightness-plus\"></i>


        <i class=\"uil-0-plus\"></i>
        <i class=\"uil-16-plus\"></i>
        <i class=\"uil-3-plus\"></i>
        <i class=\"uil-accessible-icon-alt\"></i>
        <i class=\"uil-adjust\"></i>
        <i class=\"uil-align-alt\"></i>
        <i class=\"uil-align-center-v\"></i>
        <i class=\"uil-align-left\"></i>
        <i class=\"uil-align\"></i>
        <i class=\"uil-analytics\"></i>
        <i class=\"uil-android\"></i>
        <i class=\"uil-angle-double-up\"></i>
        <i class=\"uil-angle-right\"></i>
        <i class=\"uil-annoyed-alt\"></i>
        <i class=\"uil-apps\"></i>
        <i class=\"uil-arrow-break\"></i>
        <i class=\"uil-arrow-circle-up\"></i>
        <i class=\"uil-arrow-down\"></i>
        <i class=\"uil-arrow-left\"></i>
        <i class=\"uil-arrow-to-bottom\"></i>
        <i class=\"uil-arrow-up\"></i>
        <i class=\"uil-arrows-maximize\"></i>
        <i class=\"uil-arrows-resize\"></i>
        <i class=\"uil-arrows-up-right\"></i>
        <i class=\"uil-asterisk\"></i>
        <i class=\"uil-auto-flash\"></i>
        <i class=\"uil-backpack\"></i>
        <i class=\"uil-bag-slash\"></i>
        <i class=\"uil-ban\"></i>
        <i class=\"uil-basketball\"></i>
        <i class=\"uil-bed-double\"></i>
        <i class=\"uil-bell-school\"></i>
        <i class=\"uil-bitcoin-alt\"></i>
        <i class=\"uil-black-berry\"></i>
        <i class=\"uil-bold\"></i>
        <i class=\"uil-book-alt\"></i>
        <i class=\"uil-book\"></i>
        <i class=\"uil-boombox\"></i>
        <i class=\"uil-border-horizontal\"></i>
        <i class=\"uil-border-right\"></i>
        <i class=\"uil-box\"></i>
        <i class=\"uil-brightness-empty\"></i>
        <i class=\"uil-brightness-plus\"></i>


        <i class=\"uil-0-plus\"></i>
        <i class=\"uil-16-plus\"></i>
        <i class=\"uil-3-plus\"></i>
        <i class=\"uil-accessible-icon-alt\"></i>
        <i class=\"uil-adjust\"></i>
        <i class=\"uil-align-alt\"></i>
        <i class=\"uil-align-center-v\"></i>
        <i class=\"uil-align-left\"></i>
        <i class=\"uil-align\"></i>
        <i class=\"uil-analytics\"></i>
        <i class=\"uil-android\"></i>
        <i class=\"uil-angle-double-up\"></i>
        <i class=\"uil-angle-right\"></i>
        <i class=\"uil-annoyed-alt\"></i>
        <i class=\"uil-apps\"></i>
        <i class=\"uil-arrow-break\"></i>
        <i class=\"uil-arrow-circle-up\"></i>
        <i class=\"uil-arrow-down\"></i>
        <i class=\"uil-arrow-left\"></i>
        <i class=\"uil-arrow-to-bottom\"></i>
        <i class=\"uil-arrow-up\"></i>
        <i class=\"uil-arrows-maximize\"></i>
        <i class=\"uil-arrows-resize\"></i>
        <i class=\"uil-arrows-up-right\"></i>
        <i class=\"uil-asterisk\"></i>
        <i class=\"uil-auto-flash\"></i>
        <i class=\"uil-backpack\"></i>
        <i class=\"uil-bag-slash\"></i>
        <i class=\"uil-ban\"></i>
        <i class=\"uil-basketball\"></i>
        <i class=\"uil-bed-double\"></i>
        <i class=\"uil-bell-school\"></i>
        <i class=\"uil-bitcoin-alt\"></i>
        <i class=\"uil-black-berry\"></i>
        <i class=\"uil-bold\"></i>
        <i class=\"uil-book-alt\"></i>
        <i class=\"uil-book\"></i>
        <i class=\"uil-boombox\"></i>
        <i class=\"uil-border-horizontal\"></i>
        <i class=\"uil-border-right\"></i>
        <i class=\"uil-box\"></i>
        <i class=\"uil-brightness-empty\"></i>
        <i class=\"uil-brightness-plus\"></i>
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
        return "features/icon.html.twig";
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

{% block title %}Icons - Geex Dashboard{% endblock %}

{% block mainHeader %}Icons{% endblock %}

{% block content %}Form Elements is used to style and format the input field{% endblock %}

{% block body %}

<div class=\"geex-content__section geex-content__icon\">
    <div class=\"geex-content__icon__wrapper\">
        <i class=\"uil-0-plus\"></i>
        <i class=\"uil-16-plus\"></i>
        <i class=\"uil-3-plus\"></i>
        <i class=\"uil-accessible-icon-alt\"></i>
        <i class=\"uil-adjust\"></i>
        <i class=\"uil-align-alt\"></i>
        <i class=\"uil-align-center-v\"></i>
        <i class=\"uil-align-left\"></i>
        <i class=\"uil-align\"></i>
        <i class=\"uil-analytics\"></i>
        <i class=\"uil-android\"></i>
        <i class=\"uil-angle-double-up\"></i>
        <i class=\"uil-angle-right\"></i>
        <i class=\"uil-annoyed-alt\"></i>
        <i class=\"uil-apps\"></i>
        <i class=\"uil-arrow-break\"></i>
        <i class=\"uil-arrow-circle-up\"></i>
        <i class=\"uil-arrow-down\"></i>
        <i class=\"uil-arrow-left\"></i>
        <i class=\"uil-arrow-to-bottom\"></i>
        <i class=\"uil-arrow-up\"></i>
        <i class=\"uil-arrows-maximize\"></i>
        <i class=\"uil-arrows-resize\"></i>
        <i class=\"uil-arrows-up-right\"></i>
        <i class=\"uil-asterisk\"></i>
        <i class=\"uil-auto-flash\"></i>
        <i class=\"uil-backpack\"></i>
        <i class=\"uil-bag-slash\"></i>
        <i class=\"uil-ban\"></i>
        <i class=\"uil-basketball\"></i>
        <i class=\"uil-bed-double\"></i>
        <i class=\"uil-bell-school\"></i>
        <i class=\"uil-bitcoin-alt\"></i>
        <i class=\"uil-black-berry\"></i>
        <i class=\"uil-bold\"></i>
        <i class=\"uil-book-alt\"></i>
        <i class=\"uil-book\"></i>
        <i class=\"uil-boombox\"></i>
        <i class=\"uil-border-horizontal\"></i>
        <i class=\"uil-border-right\"></i>
        <i class=\"uil-box\"></i>
        <i class=\"uil-brightness-empty\"></i>
        <i class=\"uil-brightness-plus\"></i>


        <i class=\"uil-0-plus\"></i>
        <i class=\"uil-16-plus\"></i>
        <i class=\"uil-3-plus\"></i>
        <i class=\"uil-accessible-icon-alt\"></i>
        <i class=\"uil-adjust\"></i>
        <i class=\"uil-align-alt\"></i>
        <i class=\"uil-align-center-v\"></i>
        <i class=\"uil-align-left\"></i>
        <i class=\"uil-align\"></i>
        <i class=\"uil-analytics\"></i>
        <i class=\"uil-android\"></i>
        <i class=\"uil-angle-double-up\"></i>
        <i class=\"uil-angle-right\"></i>
        <i class=\"uil-annoyed-alt\"></i>
        <i class=\"uil-apps\"></i>
        <i class=\"uil-arrow-break\"></i>
        <i class=\"uil-arrow-circle-up\"></i>
        <i class=\"uil-arrow-down\"></i>
        <i class=\"uil-arrow-left\"></i>
        <i class=\"uil-arrow-to-bottom\"></i>
        <i class=\"uil-arrow-up\"></i>
        <i class=\"uil-arrows-maximize\"></i>
        <i class=\"uil-arrows-resize\"></i>
        <i class=\"uil-arrows-up-right\"></i>
        <i class=\"uil-asterisk\"></i>
        <i class=\"uil-auto-flash\"></i>
        <i class=\"uil-backpack\"></i>
        <i class=\"uil-bag-slash\"></i>
        <i class=\"uil-ban\"></i>
        <i class=\"uil-basketball\"></i>
        <i class=\"uil-bed-double\"></i>
        <i class=\"uil-bell-school\"></i>
        <i class=\"uil-bitcoin-alt\"></i>
        <i class=\"uil-black-berry\"></i>
        <i class=\"uil-bold\"></i>
        <i class=\"uil-book-alt\"></i>
        <i class=\"uil-book\"></i>
        <i class=\"uil-boombox\"></i>
        <i class=\"uil-border-horizontal\"></i>
        <i class=\"uil-border-right\"></i>
        <i class=\"uil-box\"></i>
        <i class=\"uil-brightness-empty\"></i>
        <i class=\"uil-brightness-plus\"></i>


        <i class=\"uil-0-plus\"></i>
        <i class=\"uil-16-plus\"></i>
        <i class=\"uil-3-plus\"></i>
        <i class=\"uil-accessible-icon-alt\"></i>
        <i class=\"uil-adjust\"></i>
        <i class=\"uil-align-alt\"></i>
        <i class=\"uil-align-center-v\"></i>
        <i class=\"uil-align-left\"></i>
        <i class=\"uil-align\"></i>
        <i class=\"uil-analytics\"></i>
        <i class=\"uil-android\"></i>
        <i class=\"uil-angle-double-up\"></i>
        <i class=\"uil-angle-right\"></i>
        <i class=\"uil-annoyed-alt\"></i>
        <i class=\"uil-apps\"></i>
        <i class=\"uil-arrow-break\"></i>
        <i class=\"uil-arrow-circle-up\"></i>
        <i class=\"uil-arrow-down\"></i>
        <i class=\"uil-arrow-left\"></i>
        <i class=\"uil-arrow-to-bottom\"></i>
        <i class=\"uil-arrow-up\"></i>
        <i class=\"uil-arrows-maximize\"></i>
        <i class=\"uil-arrows-resize\"></i>
        <i class=\"uil-arrows-up-right\"></i>
        <i class=\"uil-asterisk\"></i>
        <i class=\"uil-auto-flash\"></i>
        <i class=\"uil-backpack\"></i>
        <i class=\"uil-bag-slash\"></i>
        <i class=\"uil-ban\"></i>
        <i class=\"uil-basketball\"></i>
        <i class=\"uil-bed-double\"></i>
        <i class=\"uil-bell-school\"></i>
        <i class=\"uil-bitcoin-alt\"></i>
        <i class=\"uil-black-berry\"></i>
        <i class=\"uil-bold\"></i>
        <i class=\"uil-book-alt\"></i>
        <i class=\"uil-book\"></i>
        <i class=\"uil-boombox\"></i>
        <i class=\"uil-border-horizontal\"></i>
        <i class=\"uil-border-right\"></i>
        <i class=\"uil-box\"></i>
        <i class=\"uil-brightness-empty\"></i>
        <i class=\"uil-brightness-plus\"></i>
    </div>
</div>

{% endblock %}
", "features/icon.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\features\\icon.html.twig");
    }
}
