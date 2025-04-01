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

/* features/chart.html.twig */
class __TwigTemplate_f58213a2f596a03e31e95a5269517322 extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "features/chart.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "features/chart.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "features/chart.html.twig", 1);
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

        yield "Chart - Geex Dashboard";
        
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

        yield "Chart";
        
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
<div class=\"geex-content__wrapper\">
    <div class=\"geex-content__section-wrapper\">
        <div class=\"row\">
            <div class=\"col-lg-6 mb-40\">
                <div class=\"geex-content__section geex-content__server-request\">
                    <div class=\"geex-content__section__header\">
                        <div class=\"geex-content__section__header__title-part\">
                            <h4 class=\"geex-content__section__header__title\">Server Request</h4>
                        </div>
                    </div>
                    <div class=\"geex-content__section__content\">
                        <div id=\"line-chart\" class=\"server-request-chart\"></div>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-6 mb-40\">
                <div class=\"geex-content__section\">
                    <div id=\"stack-chart\"></div>
                </div>
            </div>
            <div class=\"col-lg-6 md-mb-40\">
                <div class=\"geex-content__section geex-content__visitor-count\">
                    <div class=\"geex-content__section__header\">
                        <div class=\"geex-content__section__header__title-part\">
                            <h4 class=\"geex-content__section__header__title\">Visitors</h4>
                        </div>
                        <div class=\"geex-content__section__header__content-part\">
                            <div class=\"geex-content__section__header__btn\">
                                <a href=\"#\" class=\"geex-content__section__header__link\">
                                View More
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__section__content\">
                        <div class=\"geex-content__visitor-count__number\">
                            <h2 class=\"geex-content__visitor-count__number__title\">98,425k</h2>
                            <div class=\"geex-content__visitor-count__number__text\">
                                <span class=\"geex-content__visitor-count__number__subtitle\">+2.5%</span>
                                <p class=\"geex-content__visitor-count__number__desc\">Than last week</p>
                            </div>
                        </div>
                        <div id=\"column-chart\"></div>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-6\">
                <div class=\"geex-content__section geex-content__chat-summary\">
                    <div class=\"geex-content__section__header\">
                        <div class=\"geex-content__section__header__title-part\">
                            <h4 class=\"geex-content__section__header__title\">Chart Summary</h4>
                        </div>
                        <div class=\"geex-content__section__header__content-part\">
                            <div class=\"geex-content__section__header__btn\">
                                <a href=\"#\" class=\"geex-content__section__header__link\">
                                Download Report
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__section__content\">
                        <div id=\"pie-chart\"></div>
                    </div>
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
        return "features/chart.html.twig";
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

{% block title %}Chart - Geex Dashboard{% endblock %}

{% block mainHeader %}Chart{% endblock %}

{% block content %}Form Elements is used to style and format the input field{% endblock %}

{% block body %}

<div class=\"geex-content__wrapper\">
    <div class=\"geex-content__section-wrapper\">
        <div class=\"row\">
            <div class=\"col-lg-6 mb-40\">
                <div class=\"geex-content__section geex-content__server-request\">
                    <div class=\"geex-content__section__header\">
                        <div class=\"geex-content__section__header__title-part\">
                            <h4 class=\"geex-content__section__header__title\">Server Request</h4>
                        </div>
                    </div>
                    <div class=\"geex-content__section__content\">
                        <div id=\"line-chart\" class=\"server-request-chart\"></div>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-6 mb-40\">
                <div class=\"geex-content__section\">
                    <div id=\"stack-chart\"></div>
                </div>
            </div>
            <div class=\"col-lg-6 md-mb-40\">
                <div class=\"geex-content__section geex-content__visitor-count\">
                    <div class=\"geex-content__section__header\">
                        <div class=\"geex-content__section__header__title-part\">
                            <h4 class=\"geex-content__section__header__title\">Visitors</h4>
                        </div>
                        <div class=\"geex-content__section__header__content-part\">
                            <div class=\"geex-content__section__header__btn\">
                                <a href=\"#\" class=\"geex-content__section__header__link\">
                                View More
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__section__content\">
                        <div class=\"geex-content__visitor-count__number\">
                            <h2 class=\"geex-content__visitor-count__number__title\">98,425k</h2>
                            <div class=\"geex-content__visitor-count__number__text\">
                                <span class=\"geex-content__visitor-count__number__subtitle\">+2.5%</span>
                                <p class=\"geex-content__visitor-count__number__desc\">Than last week</p>
                            </div>
                        </div>
                        <div id=\"column-chart\"></div>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-6\">
                <div class=\"geex-content__section geex-content__chat-summary\">
                    <div class=\"geex-content__section__header\">
                        <div class=\"geex-content__section__header__title-part\">
                            <h4 class=\"geex-content__section__header__title\">Chart Summary</h4>
                        </div>
                        <div class=\"geex-content__section__header__content-part\">
                            <div class=\"geex-content__section__header__btn\">
                                <a href=\"#\" class=\"geex-content__section__header__link\">
                                Download Report
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__section__content\">
                        <div id=\"pie-chart\"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

{% endblock %}
", "features/chart.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\features\\chart.html.twig");
    }
}
