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

/* features/badge.html.twig */
class __TwigTemplate_cda4bd9baf8c9e63728ec4c22277f409 extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "features/badge.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "features/badge.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "features/badge.html.twig", 1);
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

        yield "Badge - Geex Dashboard";
        
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

        yield "Badge/Label";
        
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
    <div class=\"geex-content__form__wrapper\">
        <div class=\"geex-content__form__wrapper__item geex-content__form__left\">
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Mini badge for notification counters</h4>
                <div class=\"geex-content__form__single__box\">
                    <span class=\"geex-badge geex-badge--danger geex-badge--mini\">2</span>
                    <span class=\"geex-badge geex-badge--warning geex-badge--mini\">84</span>
                    <span class=\"geex-badge geex-badge--info geex-badge--mini\">2</span>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Text badge for status label</h4>
                <div class=\"geex-content__form__single__box\">
                    <span class=\"geex-badge geex-badge--danger\">Badge</span>
                    <span class=\"geex-badge geex-badge--success\">Badge</span>
                    <span class=\"geex-badge geex-badge--warning\">Badge</span>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Label with icon</h4>
                <div class=\"geex-content__form__single__box\">
                    <span class=\"geex-badge geex-badge--label-icon geex-badge--danger-transparent\"><i class=\"uil-arrow-down-right\"></i>Label</span>
                    <span class=\"geex-badge geex-badge--label-icon geex-badge--success-transparent\"><i class=\"uil-arrow-down-right\"></i>Label</span>
                    <span class=\"geex-badge geex-badge--label-icon geex-badge--warning-transparent\"><i class=\"uil-arrow-down-right\"></i>Label</span>
                    <span class=\"geex-badge geex-badge--label-icon geex-badge--info-transparent\"><i class=\"uil-arrow-down-right\"></i>Label</span>
                    <span class=\"geex-badge geex-badge--label-icon geex-badge--primary-transparent\"><i class=\"uil-arrow-down-right\"></i>Label</span>
                </div>
            </div>
        </div>
        <div class=\"geex-content__form__wrapper__item geex-content__form__right\">
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">File format Icon</h4>
                <div class=\"geex-content__form__single__box\">
                    <span class=\"geex-badge geex-badge--dark geex-badge--icon\">
                        <i class=\"uil-grid\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--pink geex-badge--icon\">
                        <i class=\"uil-image\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--warning geex-badge--icon\">
                        <i class=\"uil-play\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--success geex-badge--icon\">
                        <i class=\"uil-airplay\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--info geex-badge--icon\">
                        <i class=\"uil-file-alt\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--primary geex-badge--icon\">
                        <i class=\"uil-folder\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--white geex-badge--icon\">
                        <i class=\"uil-arrow-right\"></i>
                    </span>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Tooltip</h4>
                <div class=\"geex-content__form__single__box\">
                    <div class=\"geex-tooltip geex-tooltip--default\">
                        <h5 class=\"geex-tooltip__title\">24%</h5>
                        <span class=\"geex-tooltip__text\">982 Visitors</span>
                    </div>
                    <div class=\"geex-tooltip geex-tooltip--white\">
                        <h5 class=\"geex-tooltip__title\">48 Request</h5>
                        <span class=\"geex-tooltip__text\">From Web Server A</span>
                    </div>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Label Legend</h4>
                <div class=\"geex-content__form__single__box\">
                    <span class=\"geex-label geex-label--success\">Web Server A</span>
                    <span class=\"geex-label geex-label--primary\">Web Server B</span>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Icon Transaction</h4>
                <div class=\"geex-content__form__single__box\">
                    <span class=\"geex-badge geex-badge--danger-transparent geex-badge--transaction-icon\">
                        <i class=\"uil-arrow-down\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--success-transparent geex-badge--transaction-icon\">
                        <i class=\"uil-arrow-up\"></i>
                    </span>
                </div>
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
        return "features/badge.html.twig";
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

{% block title %}Badge - Geex Dashboard{% endblock %}

{% block mainHeader %}Badge/Label{% endblock %}

{% block content %}Form Elements is used to style and format the input field{% endblock %}

{% block body %}

<div class=\"geex-content__section geex-content__form\">
    <div class=\"geex-content__form__wrapper\">
        <div class=\"geex-content__form__wrapper__item geex-content__form__left\">
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Mini badge for notification counters</h4>
                <div class=\"geex-content__form__single__box\">
                    <span class=\"geex-badge geex-badge--danger geex-badge--mini\">2</span>
                    <span class=\"geex-badge geex-badge--warning geex-badge--mini\">84</span>
                    <span class=\"geex-badge geex-badge--info geex-badge--mini\">2</span>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Text badge for status label</h4>
                <div class=\"geex-content__form__single__box\">
                    <span class=\"geex-badge geex-badge--danger\">Badge</span>
                    <span class=\"geex-badge geex-badge--success\">Badge</span>
                    <span class=\"geex-badge geex-badge--warning\">Badge</span>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Label with icon</h4>
                <div class=\"geex-content__form__single__box\">
                    <span class=\"geex-badge geex-badge--label-icon geex-badge--danger-transparent\"><i class=\"uil-arrow-down-right\"></i>Label</span>
                    <span class=\"geex-badge geex-badge--label-icon geex-badge--success-transparent\"><i class=\"uil-arrow-down-right\"></i>Label</span>
                    <span class=\"geex-badge geex-badge--label-icon geex-badge--warning-transparent\"><i class=\"uil-arrow-down-right\"></i>Label</span>
                    <span class=\"geex-badge geex-badge--label-icon geex-badge--info-transparent\"><i class=\"uil-arrow-down-right\"></i>Label</span>
                    <span class=\"geex-badge geex-badge--label-icon geex-badge--primary-transparent\"><i class=\"uil-arrow-down-right\"></i>Label</span>
                </div>
            </div>
        </div>
        <div class=\"geex-content__form__wrapper__item geex-content__form__right\">
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">File format Icon</h4>
                <div class=\"geex-content__form__single__box\">
                    <span class=\"geex-badge geex-badge--dark geex-badge--icon\">
                        <i class=\"uil-grid\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--pink geex-badge--icon\">
                        <i class=\"uil-image\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--warning geex-badge--icon\">
                        <i class=\"uil-play\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--success geex-badge--icon\">
                        <i class=\"uil-airplay\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--info geex-badge--icon\">
                        <i class=\"uil-file-alt\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--primary geex-badge--icon\">
                        <i class=\"uil-folder\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--white geex-badge--icon\">
                        <i class=\"uil-arrow-right\"></i>
                    </span>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Tooltip</h4>
                <div class=\"geex-content__form__single__box\">
                    <div class=\"geex-tooltip geex-tooltip--default\">
                        <h5 class=\"geex-tooltip__title\">24%</h5>
                        <span class=\"geex-tooltip__text\">982 Visitors</span>
                    </div>
                    <div class=\"geex-tooltip geex-tooltip--white\">
                        <h5 class=\"geex-tooltip__title\">48 Request</h5>
                        <span class=\"geex-tooltip__text\">From Web Server A</span>
                    </div>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Label Legend</h4>
                <div class=\"geex-content__form__single__box\">
                    <span class=\"geex-label geex-label--success\">Web Server A</span>
                    <span class=\"geex-label geex-label--primary\">Web Server B</span>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Icon Transaction</h4>
                <div class=\"geex-content__form__single__box\">
                    <span class=\"geex-badge geex-badge--danger-transparent geex-badge--transaction-icon\">
                        <i class=\"uil-arrow-down\"></i>
                    </span>
                    <span class=\"geex-badge geex-badge--success-transparent geex-badge--transaction-icon\">
                        <i class=\"uil-arrow-up\"></i>
                    </span>
                </div>
            </div>
        </div>
    </div>
</div>

{% endblock %}
", "features/badge.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\features\\badge.html.twig");
    }
}
