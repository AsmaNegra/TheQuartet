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

/* pages/pricing.html.twig */
class __TwigTemplate_221cf2f7fe7886e83d5da55419777b1d extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/pricing.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/pricing.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "pages/pricing.html.twig", 1);
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

        yield "Pricing - Geex Dashboard";
        
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

        yield "Pricing";
        
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
<div class=\"geex-content__pricing\">
    <div class=\"geex-content__pricing__wrapper\">
        <div class=\"row\">
            <div class=\"col-lg-4 mb-40\">
                <div class=\"geex-content__pricing__single\">
                    <div class=\"geex-content__pricing__header\">
                        <span class=\"geex-content__pricing__badge\">Gold</span>
                        <div class=\"geex-content__pricing__tag\">
                            <span class=\"geex-content__pricing__currency\">\$</span>
                            <span class=\"geex-content__pricing__amount\">250</span>
                            <span class=\"geex-content__pricing__period\">per month</span>
                        </div>
                        <span class=\"geex-content__pricing__subtitle\">Grow your business with ease.</span>
                    </div>
                    <div class=\"geex-content__pricing__body\">
                        <ul class=\"geex-content__pricing__feature\">\t
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Business Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Great Customer Support</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Market Growth Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                        </ul>
                        <div class=\"geex-content__pricing__btn-part\">
                            <a class=\"geex-content__pricing__btn\" href=\"\">Try for Free</a>
                        </div>
                        <span class=\"geex-content__pricing__profit\">\$999 billed annually. Save \$189.</span>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-4 mb-40\">
                <div class=\"geex-content__pricing__single active\">
                    <div class=\"geex-content__pricing__header\">
                        <span class=\"geex-content__pricing__badge\">Platinum</span>
                        <div class=\"geex-content__pricing__tag\">
                            <span class=\"geex-content__pricing__currency\">\$</span>
                            <span class=\"geex-content__pricing__amount\">125</span>
                            <span class=\"geex-content__pricing__period\">per month</span>
                        </div>
                        <span class=\"geex-content__pricing__subtitle\">Grow your business with ease.</span>
                    </div>
                    <div class=\"geex-content__pricing__body\">
                        <ul class=\"geex-content__pricing__feature\">\t
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Business Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Great Customer Support</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Market Growth Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                        </ul>
                        <div class=\"geex-content__pricing__btn-part\">
                            <a class=\"geex-content__pricing__btn\" href=\"\">Try for Free</a>
                        </div>
                        <span class=\"geex-content__pricing__profit\">\$999 billed annually. Save \$189.</span>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-4 mb-40\">
                <div class=\"geex-content__pricing__single\">
                    <div class=\"geex-content__pricing__header\">
                        <span class=\"geex-content__pricing__badge\">Diamond</span>
                        <div class=\"geex-content__pricing__tag\">
                            <span class=\"geex-content__pricing__currency\">\$</span>
                            <span class=\"geex-content__pricing__amount\">149</span>
                            <span class=\"geex-content__pricing__period\">per month</span>
                        </div>
                        <span class=\"geex-content__pricing__subtitle\">Grow your business with ease.</span>
                    </div>
                    <div class=\"geex-content__pricing__body\">
                        <ul class=\"geex-content__pricing__feature\">\t
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Business Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Great Customer Support</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Market Growth Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                        </ul>
                        <div class=\"geex-content__pricing__btn-part\">
                            <a class=\"geex-content__pricing__btn\" href=\"\">Try for Free</a>
                        </div>
                        <span class=\"geex-content__pricing__profit\">\$999 billed annually. Save \$189.</span>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-4 md-mb-40\">
                <div class=\"geex-content__pricing__single\">
                    <div class=\"geex-content__pricing__header\">
                        <span class=\"geex-content__pricing__badge\">Titanium</span>
                        <div class=\"geex-content__pricing__tag\">
                            <span class=\"geex-content__pricing__currency\">\$</span>
                            <span class=\"geex-content__pricing__amount\">199</span>
                            <span class=\"geex-content__pricing__period\">per month</span>
                        </div>
                        <span class=\"geex-content__pricing__subtitle\">Grow your business with ease.</span>
                    </div>
                    <div class=\"geex-content__pricing__body\">
                        <ul class=\"geex-content__pricing__feature\">\t
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Business Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Great Customer Support</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Market Growth Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                        </ul>
                        <div class=\"geex-content__pricing__btn-part\">
                            <a class=\"geex-content__pricing__btn\" href=\"\">Try for Free</a>
                        </div>
                        <span class=\"geex-content__pricing__profit\">\$999 billed annually. Save \$189.</span>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-4 md-mb-40\">
                <div class=\"geex-content__pricing__single\">
                    <div class=\"geex-content__pricing__header\">
                        <span class=\"geex-content__pricing__badge\">Platinum</span>
                        <div class=\"geex-content__pricing__tag\">
                            <span class=\"geex-content__pricing__currency\">\$</span>
                            <span class=\"geex-content__pricing__amount\">125</span>
                            <span class=\"geex-content__pricing__period\">per month</span>
                        </div>
                        <span class=\"geex-content__pricing__subtitle\">Grow your business with ease.</span>
                    </div>
                    <div class=\"geex-content__pricing__body\">
                        <ul class=\"geex-content__pricing__feature\">\t
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Business Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Great Customer Support</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Market Growth Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                        </ul>
                        <div class=\"geex-content__pricing__btn-part\">
                            <a class=\"geex-content__pricing__btn\" href=\"\">Try for Free</a>
                        </div>
                        <span class=\"geex-content__pricing__profit\">\$999 billed annually. Save \$189.</span>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-4\">
                <div class=\"geex-content__pricing__single active\">
                    <div class=\"geex-content__pricing__header\">
                        <span class=\"geex-content__pricing__badge\">Diamond</span>
                        <div class=\"geex-content__pricing__tag\">
                            <span class=\"geex-content__pricing__currency\">\$</span>
                            <span class=\"geex-content__pricing__amount\">149</span>
                            <span class=\"geex-content__pricing__period\">per month</span>
                        </div>
                        <span class=\"geex-content__pricing__subtitle\">Grow your business with ease.</span>
                    </div>
                    <div class=\"geex-content__pricing__body\">
                        <ul class=\"geex-content__pricing__feature\">\t
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Business Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Great Customer Support</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Market Growth Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                        </ul>
                        <div class=\"geex-content__pricing__btn-part\">
                            <a class=\"geex-content__pricing__btn\" href=\"\">Try for Free</a>
                        </div>
                        <span class=\"geex-content__pricing__profit\">\$999 billed annually. Save \$189.</span>
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
        return "pages/pricing.html.twig";
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

{% block title %}Pricing - Geex Dashboard{% endblock %}

{% block mainHeader %}Pricing{% endblock %}

{% block content %}Form Elements is used to style and format the input field{% endblock %}

{% block body %}

<div class=\"geex-content__pricing\">
    <div class=\"geex-content__pricing__wrapper\">
        <div class=\"row\">
            <div class=\"col-lg-4 mb-40\">
                <div class=\"geex-content__pricing__single\">
                    <div class=\"geex-content__pricing__header\">
                        <span class=\"geex-content__pricing__badge\">Gold</span>
                        <div class=\"geex-content__pricing__tag\">
                            <span class=\"geex-content__pricing__currency\">\$</span>
                            <span class=\"geex-content__pricing__amount\">250</span>
                            <span class=\"geex-content__pricing__period\">per month</span>
                        </div>
                        <span class=\"geex-content__pricing__subtitle\">Grow your business with ease.</span>
                    </div>
                    <div class=\"geex-content__pricing__body\">
                        <ul class=\"geex-content__pricing__feature\">\t
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Business Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Great Customer Support</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Market Growth Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                        </ul>
                        <div class=\"geex-content__pricing__btn-part\">
                            <a class=\"geex-content__pricing__btn\" href=\"\">Try for Free</a>
                        </div>
                        <span class=\"geex-content__pricing__profit\">\$999 billed annually. Save \$189.</span>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-4 mb-40\">
                <div class=\"geex-content__pricing__single active\">
                    <div class=\"geex-content__pricing__header\">
                        <span class=\"geex-content__pricing__badge\">Platinum</span>
                        <div class=\"geex-content__pricing__tag\">
                            <span class=\"geex-content__pricing__currency\">\$</span>
                            <span class=\"geex-content__pricing__amount\">125</span>
                            <span class=\"geex-content__pricing__period\">per month</span>
                        </div>
                        <span class=\"geex-content__pricing__subtitle\">Grow your business with ease.</span>
                    </div>
                    <div class=\"geex-content__pricing__body\">
                        <ul class=\"geex-content__pricing__feature\">\t
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Business Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Great Customer Support</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Market Growth Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                        </ul>
                        <div class=\"geex-content__pricing__btn-part\">
                            <a class=\"geex-content__pricing__btn\" href=\"\">Try for Free</a>
                        </div>
                        <span class=\"geex-content__pricing__profit\">\$999 billed annually. Save \$189.</span>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-4 mb-40\">
                <div class=\"geex-content__pricing__single\">
                    <div class=\"geex-content__pricing__header\">
                        <span class=\"geex-content__pricing__badge\">Diamond</span>
                        <div class=\"geex-content__pricing__tag\">
                            <span class=\"geex-content__pricing__currency\">\$</span>
                            <span class=\"geex-content__pricing__amount\">149</span>
                            <span class=\"geex-content__pricing__period\">per month</span>
                        </div>
                        <span class=\"geex-content__pricing__subtitle\">Grow your business with ease.</span>
                    </div>
                    <div class=\"geex-content__pricing__body\">
                        <ul class=\"geex-content__pricing__feature\">\t
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Business Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Great Customer Support</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Market Growth Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                        </ul>
                        <div class=\"geex-content__pricing__btn-part\">
                            <a class=\"geex-content__pricing__btn\" href=\"\">Try for Free</a>
                        </div>
                        <span class=\"geex-content__pricing__profit\">\$999 billed annually. Save \$189.</span>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-4 md-mb-40\">
                <div class=\"geex-content__pricing__single\">
                    <div class=\"geex-content__pricing__header\">
                        <span class=\"geex-content__pricing__badge\">Titanium</span>
                        <div class=\"geex-content__pricing__tag\">
                            <span class=\"geex-content__pricing__currency\">\$</span>
                            <span class=\"geex-content__pricing__amount\">199</span>
                            <span class=\"geex-content__pricing__period\">per month</span>
                        </div>
                        <span class=\"geex-content__pricing__subtitle\">Grow your business with ease.</span>
                    </div>
                    <div class=\"geex-content__pricing__body\">
                        <ul class=\"geex-content__pricing__feature\">\t
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Business Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Great Customer Support</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Market Growth Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                        </ul>
                        <div class=\"geex-content__pricing__btn-part\">
                            <a class=\"geex-content__pricing__btn\" href=\"\">Try for Free</a>
                        </div>
                        <span class=\"geex-content__pricing__profit\">\$999 billed annually. Save \$189.</span>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-4 md-mb-40\">
                <div class=\"geex-content__pricing__single\">
                    <div class=\"geex-content__pricing__header\">
                        <span class=\"geex-content__pricing__badge\">Platinum</span>
                        <div class=\"geex-content__pricing__tag\">
                            <span class=\"geex-content__pricing__currency\">\$</span>
                            <span class=\"geex-content__pricing__amount\">125</span>
                            <span class=\"geex-content__pricing__period\">per month</span>
                        </div>
                        <span class=\"geex-content__pricing__subtitle\">Grow your business with ease.</span>
                    </div>
                    <div class=\"geex-content__pricing__body\">
                        <ul class=\"geex-content__pricing__feature\">\t
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Business Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Great Customer Support</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Market Growth Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                        </ul>
                        <div class=\"geex-content__pricing__btn-part\">
                            <a class=\"geex-content__pricing__btn\" href=\"\">Try for Free</a>
                        </div>
                        <span class=\"geex-content__pricing__profit\">\$999 billed annually. Save \$189.</span>
                    </div>
                </div>
            </div>
            <div class=\"col-lg-4\">
                <div class=\"geex-content__pricing__single active\">
                    <div class=\"geex-content__pricing__header\">
                        <span class=\"geex-content__pricing__badge\">Diamond</span>
                        <div class=\"geex-content__pricing__tag\">
                            <span class=\"geex-content__pricing__currency\">\$</span>
                            <span class=\"geex-content__pricing__amount\">149</span>
                            <span class=\"geex-content__pricing__period\">per month</span>
                        </div>
                        <span class=\"geex-content__pricing__subtitle\">Grow your business with ease.</span>
                    </div>
                    <div class=\"geex-content__pricing__body\">
                        <ul class=\"geex-content__pricing__feature\">\t
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Business Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list active\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Great Customer Support</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">Market Growth Solution</span>
                            </li>
                            <li class=\"geex-content__pricing__feature__list\">
                                <i class=\"uil-check\"></i> 
                                <span class=\"geex-content__pricing__feature__text\">24/7 Consultant Service</span>
                            </li>
                        </ul>
                        <div class=\"geex-content__pricing__btn-part\">
                            <a class=\"geex-content__pricing__btn\" href=\"\">Try for Free</a>
                        </div>
                        <span class=\"geex-content__pricing__profit\">\$999 billed annually. Save \$189.</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

{% endblock %}
", "pages/pricing.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\pages\\pricing.html.twig");
    }
}
