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

/* pages/testimonial.html.twig */
class __TwigTemplate_a13b0e71ef2593d539ddc4814d9dfaf5 extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/testimonial.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/testimonial.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "pages/testimonial.html.twig", 1);
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

        yield "Testimonial - Geex Dashboard";
        
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

        yield "Testimonial";
        
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
<div class=\"geex-content__testimonial\">
    <div class=\"row gutter-40\">
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Kevin Smith</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/1.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Jack David</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/2.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">David Hollis</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/3.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Beau Alexander</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/4.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Noah Presley</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/3.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Sawyer Ford</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/2.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">David Hollis</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/1.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Beau Alexander</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/3.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Noah Presley</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/2.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 md-mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Jack David</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/2.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 ssm-mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">David Hollis</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/3.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Beau Alexander</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/4.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
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
        return "pages/testimonial.html.twig";
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

{% block title %}Testimonial - Geex Dashboard{% endblock %}

{% block mainHeader %}Testimonial{% endblock %}

{% block content %}Form Elements is used to style and format the input field{% endblock %}

{% block body %}

<div class=\"geex-content__testimonial\">
    <div class=\"row gutter-40\">
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Kevin Smith</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/1.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Jack David</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/2.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">David Hollis</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/3.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Beau Alexander</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/4.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Noah Presley</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/3.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Sawyer Ford</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/2.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">David Hollis</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/1.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Beau Alexander</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/3.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Noah Presley</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/2.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 md-mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Jack David</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/2.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6 ssm-mb-40\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">David Hollis</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/3.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
        <div class=\"col-lg-4 col-sm-6\">
            <div class=\"geex-content__testimonial__single\">
                <img src=\"assets/img/icon/quotes.svg\" alt=\"image\" class=\"geex-content__testimonial__single__quote\">
                <p class=\"geex-content__testimonial__single__desc\">It’s like having a superpower! I’ve tried almost every alternative and competitor and found anything.</p>
                <div class=\"geex-content__testimonial__single__author\">
                    <h6 class=\"geex-content__testimonial__single__author__title\">Beau Alexander</h6>
                    <span class=\"geex-content__testimonial__single__author__subtitle\">Merchandising Market Manager</span>
                    <img src=\"assets/img/testimonial/4.svg\" alt=\"image\" class=\"geex-content__testimonial__single__author__img\">
                </div>
            </div>
        </div>
    </div>
</div>

{% endblock %}
", "pages/testimonial.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\pages\\testimonial.html.twig");
    }
}
