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

/* pages/faq.html.twig */
class __TwigTemplate_8988f981ed50c597cdb9cea1b1ea3e1b extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/faq.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/faq.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "pages/faq.html.twig", 1);
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

        yield "Faq - Geex Dashboard";
        
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

        yield "Faq";
        
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
<div class=\"geex-content__faq\">
    <div class=\"geex-content__faq__wrapper\">
        <div class=\"row\">
            <div class=\"col-lg-6\">
                <div class=\"geex-content__faq__single\" id=\"faqAccordionOne\">
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingOne\">
                            <button class=\"geex-content__faq__accordion__button\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseOne\" aria-expanded=\"true\" aria-controls=\"collapseOne\">
                                What are your core services UX design and branding firm?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseOne\" class=\"geex-content__faq__accordion__content collapse show\" aria-labelledby=\"headingOne\" data-bs-parent=\"#faqAccordionOne\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design and development of marketing websites.
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingTwo\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseTwo\" aria-expanded=\"false\" aria-controls=\"collapseTwo\">
                                Do you work with clients in different timezones?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseTwo\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingTwo\" data-bs-parent=\"#faqAccordionOne\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design and development of marketing websites.
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingThree\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseThree\" aria-expanded=\"false\" aria-controls=\"collapseThree\">
                                What separates you from other branding agencies?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseThree\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingThree\" data-bs-parent=\"#faqAccordionOne\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design 
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingTen\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseFour\" aria-expanded=\"false\" aria-controls=\"collapseFour\">
                                How much does hiring you for a design project cost?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseFour\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingFour\" data-bs-parent=\"#faqAccordionOne\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design and development of marketing websites.
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingSix\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseSix\" aria-expanded=\"false\" aria-controls=\"collapseSix\">
                                Can you help us redesign our B2B/enterprise software?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseSix\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingSix\" data-bs-parent=\"#faqAccordionOne\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design 
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingFive\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseFive\" aria-expanded=\"false\" aria-controls=\"collapseFive\">
                                Do you work with startups?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseFive\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingFive\" data-bs-parent=\"#faqAccordionOne\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-6\">
                <div class=\"geex-content__faq__single\" id=\"faqAccordionTwo\">
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingSeven\">
                            <button class=\"geex-content__faq__accordion__button\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseSeven\" aria-expanded=\"true\" aria-controls=\"collapseSeven\">
                                What are your core services UX design and branding firm?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseSeven\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingSeven\" data-bs-parent=\"#faqAccordionTwo\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design and development of marketing websites.
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingEight\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseEight\" aria-expanded=\"false\" aria-controls=\"collapseEight\">
                                Do you work with clients in different timezones?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseEight\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingEight\" data-bs-parent=\"#faqAccordionTwo\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design and development of marketing websites.
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingNine\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseNine\" aria-expanded=\"false\" aria-controls=\"collapseNine\">
                                What separates you from other branding agencies?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseNine\" class=\"geex-content__faq__accordion__content collapse show\" aria-labelledby=\"headingNine\" data-bs-parent=\"#faqAccordionTwo\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design 
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingTen\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseTen\" aria-expanded=\"false\" aria-controls=\"collapseTen\">
                                How much does hiring you for a design project cost?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseTen\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingTen\" data-bs-parent=\"#faqAccordionTwo\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design and development of marketing websites.
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingEleven\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseEleven\" aria-expanded=\"false\" aria-controls=\"collapseEleven\">
                                Can you help us redesign our B2B/enterprise software?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseEleven\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingEleven\" data-bs-parent=\"#faqAccordionTwo\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design 
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingTwelve\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseTwelve\" aria-expanded=\"false\" aria-controls=\"collapseTwelve\">
                                Do you work with startups?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseTwelve\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingTwelve\" data-bs-parent=\"#faqAccordionTwo\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design 
                            </div>
                        </div>
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
        return "pages/faq.html.twig";
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

{% block title %}Faq - Geex Dashboard{% endblock %}

{% block mainHeader %}Faq{% endblock %}

{% block content %}Form Elements is used to style and format the input field{% endblock %}

{% block body %}

<div class=\"geex-content__faq\">
    <div class=\"geex-content__faq__wrapper\">
        <div class=\"row\">
            <div class=\"col-lg-6\">
                <div class=\"geex-content__faq__single\" id=\"faqAccordionOne\">
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingOne\">
                            <button class=\"geex-content__faq__accordion__button\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseOne\" aria-expanded=\"true\" aria-controls=\"collapseOne\">
                                What are your core services UX design and branding firm?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseOne\" class=\"geex-content__faq__accordion__content collapse show\" aria-labelledby=\"headingOne\" data-bs-parent=\"#faqAccordionOne\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design and development of marketing websites.
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingTwo\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseTwo\" aria-expanded=\"false\" aria-controls=\"collapseTwo\">
                                Do you work with clients in different timezones?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseTwo\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingTwo\" data-bs-parent=\"#faqAccordionOne\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design and development of marketing websites.
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingThree\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseThree\" aria-expanded=\"false\" aria-controls=\"collapseThree\">
                                What separates you from other branding agencies?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseThree\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingThree\" data-bs-parent=\"#faqAccordionOne\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design 
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingTen\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseFour\" aria-expanded=\"false\" aria-controls=\"collapseFour\">
                                How much does hiring you for a design project cost?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseFour\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingFour\" data-bs-parent=\"#faqAccordionOne\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design and development of marketing websites.
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingSix\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseSix\" aria-expanded=\"false\" aria-controls=\"collapseSix\">
                                Can you help us redesign our B2B/enterprise software?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseSix\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingSix\" data-bs-parent=\"#faqAccordionOne\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design 
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingFive\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseFive\" aria-expanded=\"false\" aria-controls=\"collapseFive\">
                                Do you work with startups?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseFive\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingFive\" data-bs-parent=\"#faqAccordionOne\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-6\">
                <div class=\"geex-content__faq__single\" id=\"faqAccordionTwo\">
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingSeven\">
                            <button class=\"geex-content__faq__accordion__button\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseSeven\" aria-expanded=\"true\" aria-controls=\"collapseSeven\">
                                What are your core services UX design and branding firm?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseSeven\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingSeven\" data-bs-parent=\"#faqAccordionTwo\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design and development of marketing websites.
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingEight\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseEight\" aria-expanded=\"false\" aria-controls=\"collapseEight\">
                                Do you work with clients in different timezones?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseEight\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingEight\" data-bs-parent=\"#faqAccordionTwo\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design and development of marketing websites.
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingNine\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseNine\" aria-expanded=\"false\" aria-controls=\"collapseNine\">
                                What separates you from other branding agencies?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseNine\" class=\"geex-content__faq__accordion__content collapse show\" aria-labelledby=\"headingNine\" data-bs-parent=\"#faqAccordionTwo\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design 
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingTen\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseTen\" aria-expanded=\"false\" aria-controls=\"collapseTen\">
                                How much does hiring you for a design project cost?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseTen\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingTen\" data-bs-parent=\"#faqAccordionTwo\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design and development of marketing websites.
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingEleven\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseEleven\" aria-expanded=\"false\" aria-controls=\"collapseEleven\">
                                Can you help us redesign our B2B/enterprise software?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseEleven\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingEleven\" data-bs-parent=\"#faqAccordionTwo\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design 
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__faq__accordion__item\">
                        <h2 class=\"geex-content__faq__accordion__header\" id=\"headingTwelve\">
                            <button class=\"geex-content__faq__accordion__button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseTwelve\" aria-expanded=\"false\" aria-controls=\"collapseTwelve\">
                                Do you work with startups?
                                <i class=\"uil uil-angle-up\"></i>
                            </button>
                        </h2>
                        <div id=\"collapseTwelve\" class=\"geex-content__faq__accordion__content collapse\" aria-labelledby=\"headingTwelve\" data-bs-parent=\"#faqAccordionTwo\">
                            <div class=\"geex-content__faq__accordion__body\">
                                However, our passion for branding and the demand from our clients led us to expand our offering to provide full-service brand design practice and web design 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

{% endblock %}
", "pages/faq.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\pages\\faq.html.twig");
    }
}
