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

/* pages/blog.html.twig */
class __TwigTemplate_5ec4d0b17197439abe0cb3d9b0f09905 extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/blog.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/blog.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "pages/blog.html.twig", 1);
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

        yield "Blog - Geex Dashboard";
        
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

        yield "Blog";
        
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
<div class=\"geex-content__blog\">
    <div class=\"geex-content__blog__wrapper\">
        <div class=\"row\">
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/2.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">Getting eyeballs what you write for business tricky.</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/4.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">Which tool seems the best
                                content writing strategy</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/3.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">More then just buzzwords
                                market concepts of SEO</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/1.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">Understanding Lending
                                The Basics and Beyond</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-sm-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/2.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">Getting eyeballs what you
                                write for business is tricky</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-sm-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/3.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">Xi, Putin hail 'new era' of ties in united...</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-sm-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/4.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">How to Start Cloud Kitchen 6 Proven Steps.</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/1.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">What can you pay and buy
                                with a credit card?.</a>
                        </h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class=\"geex-content__form__single d-flex gap-20 justify-content-between pb-0\">
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
        return "pages/blog.html.twig";
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

{% block title %}Blog - Geex Dashboard{% endblock %}

{% block mainHeader %}Blog{% endblock %}

{% block content %}Form Elements is used to style and format the input field{% endblock %}

{% block body %}

<div class=\"geex-content__blog\">
    <div class=\"geex-content__blog__wrapper\">
        <div class=\"row\">
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/2.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">Getting eyeballs what you write for business tricky.</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/4.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">Which tool seems the best
                                content writing strategy</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/3.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">More then just buzzwords
                                market concepts of SEO</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/1.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">Understanding Lending
                                The Basics and Beyond</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-sm-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/2.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">Getting eyeballs what you
                                write for business is tricky</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-sm-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/3.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">Xi, Putin hail 'new era' of ties in united...</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6 mb-sm-25\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/4.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">How to Start Cloud Kitchen 6 Proven Steps.</a>
                        </h5>
                    </div>
                </div>
            </div>
            <div class=\"col-xxl-3 col-xl-4 col-md-6\">
                <div class=\"geex-content__blog__single\">
                    <div class=\"geex-content__blog__single__img\">
                        <a href=\"blog-details\">
                            <img src=\"assets/img/blog/1.png\" alt=\"Single Blog\" />
                        </a>
                    </div>
                    <div class=\"geex-content__blog__single__content\">
                        <div class=\"geex-content__blog__single__quickinfo\">
                            <a href=\"#\">Amir Nisi</a>
                            <span>10 September, 2024</span>
                        </div>
                        <h5 class=\"geex-content__blog__single__title\">
                            <a href=\"blog-details\">What can you pay and buy
                                with a credit card?.</a>
                        </h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class=\"geex-content__form__single d-flex gap-20 justify-content-between pb-0\">
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

{% endblock %}
", "pages/blog.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\pages\\blog.html.twig");
    }
}
