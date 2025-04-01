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

/* features/navigation.html.twig */
class __TwigTemplate_cd1db16baa31fe841b45d45b8e2bcb3c extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "features/navigation.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "features/navigation.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "features/navigation.html.twig", 1);
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

        yield "Navigation - Geex Dashboard";
        
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

        yield "Navigation";
        
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
            <div class=\"geex-content__form__single d-flex gap-20 justify-content-between\">
                <div class=\"geex-content__form__single__left\">
                    <h4 class=\"geex-content__form__single-action__label\">Email</h4>\t
                    <p class=\"geex-content__form__single-action__text\">Welcome to Geex Modern Admin Dashboard</p>
                </div>
                <div class=\"geex-content__form__single__right d-flex gap-20\">
                    <div class=\"geex-content__header__searchform\">
                        <input type=\"text\" id=\"search2\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                        <i class=\"uil uil-search\"></i>
                    </div>
                    <ul class=\"geex-content__header__quickaction\">
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <img class=\"notification-img\" src=\"assets/img/avatar/chat.svg\" alt=\"chat\" />
                                <span class=\"geex-content__header__badge\">84</span>
                            </a>
                        </li>
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <img class=\"notification-img\" src=\"assets/img/avatar/notification.svg\" alt=\"chat\" />
                                <span class=\"geex-content__header__badge bg-info\">2</span>
                            </a>
                        </li>
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <img class=\"user-img\" src=\"assets/img/avatar/user.svg\" alt=\"user\" />
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class=\"geex-content__form__single d-flex gap-20 justify-content-between\">
                <div class=\"geex-content__form__single__left\">
                    <h4 class=\"geex-content__form__single-action__label\">Dashboard</h4>\t
                    <p class=\"geex-content__form__single-action__text\">Welcome to Geex Modern Admin Dashboard</p>
                </div>
                <div class=\"geex-content__form__single__right d-flex gap-20\">
                    <ul class=\"geex-content__header__quickaction\">
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <i class=\"uil uil-search\"></i>
                            </a>
                        </li>
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <img class=\"notification-img\" src=\"assets/img/avatar/chat.svg\" alt=\"chat\" />
                                <span class=\"geex-content__header__badge\">5</span>
                            </a>
                        </li>
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <img class=\"notification-img\" src=\"assets/img/avatar/notification.svg\" alt=\"chat\" />
                                <span class=\"geex-content__header__badge bg-info\">15</span>
                            </a>
                        </li>
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <img class=\"user-img\" src=\"assets/img/avatar/user.svg\" alt=\"user\" />
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class=\"geex-content__form__single d-flex gap-20 justify-content-between\">
                <div class=\"geex-content__form__single__left\">
                    <p class=\"geex-content__form__single__text\">Showing 4 of 256 data</p>
                </div>
                <div class=\"geex-content__form__single__right d-flex gap-20\">
                    <ul class=\"geex-content__pagination flex gap-10\">
                        <li class=\"geex-content__pagination__item\">
                            <a href=\"#\" class=\"geex-content__pagination__link active\">
                                1
                            </a>
                        </li>
                        <li class=\"geex-content__pagination__item\">
                            <a href=\"#\" class=\"geex-content__pagination__link\">
                                2
                            </a>
                        </li>
                        <li class=\"geex-content__pagination__item\">
                            <a href=\"#\" class=\"geex-content__pagination__link\">
                                3
                            </a>
                        </li>
                    </ul>
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
        return "features/navigation.html.twig";
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

{% block title %}Navigation - Geex Dashboard{% endblock %}

{% block mainHeader %}Navigation{% endblock %}

{% block content %}Form Elements is used to style and format the input field{% endblock %}

{% block body %}

<div class=\"geex-content__section geex-content__form\">
    <div class=\"geex-content__form__wrapper\">
        <div class=\"geex-content__form__wrapper__item geex-content__form__left\">
            <div class=\"geex-content__form__single d-flex gap-20 justify-content-between\">
                <div class=\"geex-content__form__single__left\">
                    <h4 class=\"geex-content__form__single-action__label\">Email</h4>\t
                    <p class=\"geex-content__form__single-action__text\">Welcome to Geex Modern Admin Dashboard</p>
                </div>
                <div class=\"geex-content__form__single__right d-flex gap-20\">
                    <div class=\"geex-content__header__searchform\">
                        <input type=\"text\" id=\"search2\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                        <i class=\"uil uil-search\"></i>
                    </div>
                    <ul class=\"geex-content__header__quickaction\">
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <img class=\"notification-img\" src=\"assets/img/avatar/chat.svg\" alt=\"chat\" />
                                <span class=\"geex-content__header__badge\">84</span>
                            </a>
                        </li>
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <img class=\"notification-img\" src=\"assets/img/avatar/notification.svg\" alt=\"chat\" />
                                <span class=\"geex-content__header__badge bg-info\">2</span>
                            </a>
                        </li>
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <img class=\"user-img\" src=\"assets/img/avatar/user.svg\" alt=\"user\" />
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class=\"geex-content__form__single d-flex gap-20 justify-content-between\">
                <div class=\"geex-content__form__single__left\">
                    <h4 class=\"geex-content__form__single-action__label\">Dashboard</h4>\t
                    <p class=\"geex-content__form__single-action__text\">Welcome to Geex Modern Admin Dashboard</p>
                </div>
                <div class=\"geex-content__form__single__right d-flex gap-20\">
                    <ul class=\"geex-content__header__quickaction\">
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <i class=\"uil uil-search\"></i>
                            </a>
                        </li>
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <img class=\"notification-img\" src=\"assets/img/avatar/chat.svg\" alt=\"chat\" />
                                <span class=\"geex-content__header__badge\">5</span>
                            </a>
                        </li>
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <img class=\"notification-img\" src=\"assets/img/avatar/notification.svg\" alt=\"chat\" />
                                <span class=\"geex-content__header__badge bg-info\">15</span>
                            </a>
                        </li>
                        <li class=\"geex-content__header__quickaction__item\">
                            <a href=\"#\" class=\"geex-content__header__quickaction__link\">
                                <img class=\"user-img\" src=\"assets/img/avatar/user.svg\" alt=\"user\" />
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class=\"geex-content__form__single d-flex gap-20 justify-content-between\">
                <div class=\"geex-content__form__single__left\">
                    <p class=\"geex-content__form__single__text\">Showing 4 of 256 data</p>
                </div>
                <div class=\"geex-content__form__single__right d-flex gap-20\">
                    <ul class=\"geex-content__pagination flex gap-10\">
                        <li class=\"geex-content__pagination__item\">
                            <a href=\"#\" class=\"geex-content__pagination__link active\">
                                1
                            </a>
                        </li>
                        <li class=\"geex-content__pagination__item\">
                            <a href=\"#\" class=\"geex-content__pagination__link\">
                                2
                            </a>
                        </li>
                        <li class=\"geex-content__pagination__item\">
                            <a href=\"#\" class=\"geex-content__pagination__link\">
                                3
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

{% endblock %}
", "features/navigation.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\features\\navigation.html.twig");
    }
}
