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

/* home/index.html.twig */
class __TwigTemplate_da1d4493f4394d55316385028f0149ba extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "home/index.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "home/index.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "home/index.html.twig", 1);
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

        yield "Geex - Dashboard";
        
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

        yield "Dashboard";
        
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

        yield "Welcome to Geex Modern Admin Dashboard";
        
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
\t<div class=\"geex-content__wrapper\">
\t\t<div class=\"geex-content__section-wrapper\">
\t\t\t<div class=\"geex-content__feature mb-40\">
\t\t\t\t<div class=\"geex-content__feature__card\">
\t\t\t\t\t<div class=\"geex-content__feature__card__text\">
\t\t\t\t\t\t<p class=\"geex-content__feature__card__subtitle\">Memory</p>
\t\t\t\t\t\t<h4 class=\"geex-content__feature__card__title\">200TB</h4>
\t\t\t\t\t\t<span class=\"geex-content__feature__card__badge\">+2.5%</span>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__feature__card__img\">
\t\t\t\t\t\t<img src=\"assets/img/feature/feature-2.svg\" alt=\"feature\" />
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__feature__card\">
\t\t\t\t\t<div class=\"geex-content__feature__card__text\">
\t\t\t\t\t\t<p class=\"geex-content__feature__card__subtitle\">Visitors</p>
\t\t\t\t\t\t<h4 class=\"geex-content__feature__card__title\">87,245k</h4>
\t\t\t\t\t\t<span class=\"geex-content__feature__card__badge danger-color\">-4.4%</span>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__feature__card__img\">
\t\t\t\t\t\t<img src=\"assets/img/feature/feature-3.svg\" alt=\"feature\" />
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__feature__card\">
\t\t\t\t\t<div class=\"geex-content__feature__card__text\">
\t\t\t\t\t\t<p class=\"geex-content__feature__card__subtitle\">New Users</p>
\t\t\t\t\t\t<h4 class=\"geex-content__feature__card__title\">4,750</h4>
\t\t\t\t\t\t<span class=\"geex-content__feature__card__badge\">+2.5%</span>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__feature__card__img\">
\t\t\t\t\t\t<img src=\"assets/img/feature/feature-1.svg\" alt=\"feature\" />
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t</div>

\t\t\t<div class=\"geex-content__section geex-content__server-request mb-40\">
\t\t\t\t<div class=\"geex-content__section__header\">
\t\t\t\t\t<div class=\"geex-content__section__header__title-part\">
\t\t\t\t\t\t<h4 class=\"geex-content__section__header__title\">Server Request</h4>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__section__content\">
\t\t\t\t\t<div id=\"line-chart\" class=\"server-request-chart\"></div>
\t\t\t\t</div>
\t\t\t</div>

\t\t\t<div class=\"geex-content__double-column mb-40\">
\t\t\t\t<div class=\"geex-content__section geex-content__visitor-count\">
\t\t\t\t\t<div class=\"geex-content__section__header\">
\t\t\t\t\t\t<div class=\"geex-content__section__header__title-part\">
\t\t\t\t\t\t\t<h4 class=\"geex-content__section__header__title\">Visitors</h4>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__section__header__content-part\">
\t\t\t\t\t\t\t<div class=\"geex-content__section__header__btn\">
\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__section__header__link\">
\t\t\t\t\t\t\t\tView More
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__section__content\">
\t\t\t\t\t\t<div class=\"geex-content__visitor-count__number\">
\t\t\t\t\t\t\t<h2 class=\"geex-content__visitor-count__number__title\">98,425k</h2>
\t\t\t\t\t\t\t<div class=\"geex-content__visitor-count__number__text\">
\t\t\t\t\t\t\t\t<span class=\"geex-content__visitor-count__number__subtitle\">+2.5%</span>
\t\t\t\t\t\t\t\t<p class=\"geex-content__visitor-count__number__desc\">Than last week</p>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div id=\"column-chart\"></div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__section geex-content__chat-summary\">
\t\t\t\t\t<div class=\"geex-content__section__header\">
\t\t\t\t\t\t<div class=\"geex-content__section__header__title-part\">
\t\t\t\t\t\t\t<h4 class=\"geex-content__section__header__title\">Chart Summary</h4>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__section__header__content-part\">
\t\t\t\t\t\t\t<div class=\"geex-content__section__header__btn\">
\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__section__header__link\">
\t\t\t\t\t\t\t\tDownload Report
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__section__content\">
\t\t\t\t\t\t<div id=\"pie-chart\"></div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t</div>

\t\t\t<div class=\"geex-content__section geex-content__section--transparent geex-content__review\">
\t\t\t\t<div class=\"geex-content__section__header\">
\t\t\t\t\t<div class=\"geex-content__section__header__title-part\">
\t\t\t\t\t\t<h4 class=\"geex-content__section__header__title\">User Review</h4>
\t\t\t\t\t\t<p class=\"geex-content__section__header__subtitle\">Eum fuga consequuntur ut et.</p>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__section__header__content-part\">
\t\t\t\t\t\t<div class=\"geex-content__section__header__btn geex-content__section__header__swiper-btn\">
\t\t\t\t\t\t\t<div class=\"swiper-btn swiper-btn-prev\">
\t\t\t\t\t\t\t\t<i class=\"uil-arrow-left\"></i>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<div class=\"swiper-btn swiper-btn-next\">
\t\t\t\t\t\t\t\t<i class=\"uil-arrow-right\"></i>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__section__content\">
\t\t\t\t\t<div class=\"swiper-container\">
\t\t\t\t\t\t<div class=\"swiper-wrapper\">
\t\t\t\t\t\t\t<div class=\"swiper-slide\">
\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single\">
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header\">
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__img\">
\t\t\t\t\t\t\t\t\t\t\t<img src=\"assets/img/testimonial/1.svg\" alt=\"User\" />
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__text\">
\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"geex-content__review__single__header__title\">John Doe</h4>
\t\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__header__subtitle\">4 days ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__content\">
\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__content__text\">Ab architecto provident ex accusantium deserunt. Aut aspernatur deleniti sit maiores ut id cum accusamus. Beatae n</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__bottom\">
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn danger-color\">Archive</a>
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn success-color\">Accept</a>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<div class=\"swiper-slide\">
\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single\">
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header\">
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__img\">
\t\t\t\t\t\t\t\t\t\t\t<img src=\"assets/img/testimonial/2.svg\" alt=\"User\" />
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__text\">
\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"geex-content__review__single__header__title\">Kevin Hunt</h4>
\t\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__header__subtitle\">6 days ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__content\">
\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__content__text\">Ab architecto provident ex accusantium deserunt. Aut aspernatur deleniti sit maiores ut id cum accusamus. Beatae n</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__bottom\">
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn danger-color\">Archive</a>
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn success-color\">Accept</a>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<div class=\"swiper-slide\">
\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single\">
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header\">
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__img\">
\t\t\t\t\t\t\t\t\t\t\t<img src=\"assets/img/testimonial/3.svg\" alt=\"User\" />
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__text\">
\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"geex-content__review__single__header__title\">Isabbelle</h4>
\t\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__header__subtitle\">7 days ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__content\">
\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__content__text\">Ab architecto provident ex accusantium deserunt. Aut aspernatur deleniti sit maiores ut id cum accusamus. Beatae n</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__bottom\">
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn success-color\">Publish <i class=\"uil-arrow-right\"></i></a>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<div class=\"swiper-slide\">
\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single\">
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header\">
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__img\">
\t\t\t\t\t\t\t\t\t\t\t<img src=\"assets/img/testimonial/4.svg\" alt=\"User\" />
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__text\">
\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"geex-content__review__single__header__title\">Kevin Hunt</h4>
\t\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__header__subtitle\">6 days ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__content\">
\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__content__text\">Ab architecto provident ex accusantium deserunt. Aut aspernatur deleniti sit maiores ut id cum accusamus. Beatae n</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__bottom\">
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn danger-color\">Archive</a>
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn success-color\">Accept</a>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<div class=\"swiper-slide\">
\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single\">
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header\">
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__img\">
\t\t\t\t\t\t\t\t\t\t\t<img src=\"assets/img/testimonial/2.svg\" alt=\"User\" />
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__text\">
\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"geex-content__review__single__header__title\">Isabbelle</h4>
\t\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__header__subtitle\">7 days ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__content\">
\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__content__text\">Ab architecto provident ex accusantium deserunt. Aut aspernatur deleniti sit maiores ut id cum accusamus. Beatae n</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__bottom\">
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn success-color\">Publish <i class=\"uil-arrow-right\"></i></a>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<!-- Add more slides as needed -->
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t</div>
\t\t</div>

\t\t<div class=\"geex-content__widget\">
\t\t\t<div class=\"geex-content__widget__single\">
\t\t\t\t<div class=\"geex-content__widget__single__header\">
\t\t\t\t\t<h4 class=\"geex-content__widget__single__title\">Server Status</h4>
\t\t\t\t\t<p class=\"geex-content__widget__single__subtitle\">Consectetur et quo dolor vero.</p>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__widget__single__content\">
\t\t\t\t\t<div id=\"stack-chart\"></div>
\t\t\t\t</div>
\t\t\t</div>
\t\t\t<div class=\"geex-content__widget__single\">
\t\t\t\t<div class=\"geex-content__widget__single__header\">
\t\t\t\t\t<h4 class=\"geex-content__widget__single__title\">Recent Problems</h4>
\t\t\t\t\t<p class=\"geex-content__widget__single__subtitle\">Maiores dicta atque dolorem temporibus</p>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__widget__single__content\">
\t\t\t\t\t<div class=\"geex-content__widget__single__cta mb-30\">
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__img\">
\t\t\t\t\t\t\t<img src=\"assets/img/icon/google.svg\" alt=\"google\" />
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__text\">
\t\t\t\t\t\t\t<h4 class=\"geex-content__widget__single__cta__title\">Google</h4>
\t\t\t\t\t\t\t<a href=\"https://www.google.com\" class=\"geex-content__widget__single__cta__link\">https://www.google.com</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__status\">
\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__widget__single__cta__btn danger-bg\">Down</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__widget__single__cta mb-30\">
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__img\">
\t\t\t\t\t\t\t<img src=\"assets/img/icon/facebook.svg\" alt=\"google\" />
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__text\">
\t\t\t\t\t\t\t<h4 class=\"geex-content__widget__single__cta__title\">Facebook</h4>
\t\t\t\t\t\t\t<a href=\"https://www.google.com\" class=\"geex-content__widget__single__cta__link\">https://www.facebook.com</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__status\">
\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__widget__single__cta__btn success-bg\">Stable</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__widget__single__cta\">
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__img\">
\t\t\t\t\t\t\t<img src=\"assets/img/icon/youtube.svg\" alt=\"google\" />
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__text\">
\t\t\t\t\t\t\t<h4 class=\"geex-content__widget__single__cta__title\">Youtube</h4>
\t\t\t\t\t\t\t<a href=\"https://www.google.com\" class=\"geex-content__widget__single__cta__link\">https://www.youtube.com</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__status\">
\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__widget__single__cta__btn warning-bg\">Warning</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t</div>
\t\t\t<div class=\"geex-content__widget__single\">
\t\t\t\t<div class=\"geex-content__widget__single__header\">
\t\t\t\t\t<h4 class=\"geex-content__widget__single__title\">Latest Activity</h4>
\t\t\t\t\t<p class=\"geex-content__widget__single__subtitle\">Sit et tempora dicta omnis ab quia quo quo.</p>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__widget__single__content\">
\t\t\t\t\t<div class=\"geex-content__widget__single__timeline\">
\t\t\t\t\t\t<div class=\"geex-content__widget__single__timeline__content\">
\t\t\t\t\t\t<h4 class=\"geex-content__widget__single__timeline__content__title\">January 2nd, 04:35 AM</h4>
\t\t\t\t\t\t<p class=\"geex-content__widget__single__timeline__content__subtitle\">Illum omnis quo illum nisi. Nesciunt est accusamus. Blanditiis nisi quae eum nisi similique. Modi consequuntur totam</p>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__widget__single__timeline\">
\t\t\t\t\t\t<div class=\"geex-content__widget__single__timeline__content\">
\t\t\t\t\t\t<h4 class=\"geex-content__widget__single__timeline__content__title\">January 4th, 06:19 AM</h4>
\t\t\t\t\t\t<p class=\"geex-content__widget__single__timeline__content__subtitle\">Corrupti unde qui molestiae labore ad adipisci veniam perspiciatis quasi. Quae labore vel.</p>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__widget__single__timeline\">
\t\t\t\t\t\t<div class=\"geex-content__widget__single__timeline__content\">
\t\t\t\t\t\t<h4 class=\"geex-content__widget__single__timeline__content__title\">January 5th, 12:34 AM</h4>
\t\t\t\t\t\t<p class=\"geex-content__widget__single__timeline__content__subtitle\">Maiores doloribus qui. Repellat accusamus minima ipsa ipsam aut debitis quis sit voluptates. Amet necessitatibus non minus quaerat et quis.</p>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t</div>
\t\t</div>
\t</div>

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
        return "home/index.html.twig";
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

{% block title %}Geex - Dashboard{% endblock %}

{% block mainHeader %}Dashboard{% endblock %}

{% block content %}Welcome to Geex Modern Admin Dashboard{% endblock %}

{% block body %}

\t<div class=\"geex-content__wrapper\">
\t\t<div class=\"geex-content__section-wrapper\">
\t\t\t<div class=\"geex-content__feature mb-40\">
\t\t\t\t<div class=\"geex-content__feature__card\">
\t\t\t\t\t<div class=\"geex-content__feature__card__text\">
\t\t\t\t\t\t<p class=\"geex-content__feature__card__subtitle\">Memory</p>
\t\t\t\t\t\t<h4 class=\"geex-content__feature__card__title\">200TB</h4>
\t\t\t\t\t\t<span class=\"geex-content__feature__card__badge\">+2.5%</span>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__feature__card__img\">
\t\t\t\t\t\t<img src=\"assets/img/feature/feature-2.svg\" alt=\"feature\" />
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__feature__card\">
\t\t\t\t\t<div class=\"geex-content__feature__card__text\">
\t\t\t\t\t\t<p class=\"geex-content__feature__card__subtitle\">Visitors</p>
\t\t\t\t\t\t<h4 class=\"geex-content__feature__card__title\">87,245k</h4>
\t\t\t\t\t\t<span class=\"geex-content__feature__card__badge danger-color\">-4.4%</span>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__feature__card__img\">
\t\t\t\t\t\t<img src=\"assets/img/feature/feature-3.svg\" alt=\"feature\" />
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__feature__card\">
\t\t\t\t\t<div class=\"geex-content__feature__card__text\">
\t\t\t\t\t\t<p class=\"geex-content__feature__card__subtitle\">New Users</p>
\t\t\t\t\t\t<h4 class=\"geex-content__feature__card__title\">4,750</h4>
\t\t\t\t\t\t<span class=\"geex-content__feature__card__badge\">+2.5%</span>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__feature__card__img\">
\t\t\t\t\t\t<img src=\"assets/img/feature/feature-1.svg\" alt=\"feature\" />
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t</div>

\t\t\t<div class=\"geex-content__section geex-content__server-request mb-40\">
\t\t\t\t<div class=\"geex-content__section__header\">
\t\t\t\t\t<div class=\"geex-content__section__header__title-part\">
\t\t\t\t\t\t<h4 class=\"geex-content__section__header__title\">Server Request</h4>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__section__content\">
\t\t\t\t\t<div id=\"line-chart\" class=\"server-request-chart\"></div>
\t\t\t\t</div>
\t\t\t</div>

\t\t\t<div class=\"geex-content__double-column mb-40\">
\t\t\t\t<div class=\"geex-content__section geex-content__visitor-count\">
\t\t\t\t\t<div class=\"geex-content__section__header\">
\t\t\t\t\t\t<div class=\"geex-content__section__header__title-part\">
\t\t\t\t\t\t\t<h4 class=\"geex-content__section__header__title\">Visitors</h4>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__section__header__content-part\">
\t\t\t\t\t\t\t<div class=\"geex-content__section__header__btn\">
\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__section__header__link\">
\t\t\t\t\t\t\t\tView More
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__section__content\">
\t\t\t\t\t\t<div class=\"geex-content__visitor-count__number\">
\t\t\t\t\t\t\t<h2 class=\"geex-content__visitor-count__number__title\">98,425k</h2>
\t\t\t\t\t\t\t<div class=\"geex-content__visitor-count__number__text\">
\t\t\t\t\t\t\t\t<span class=\"geex-content__visitor-count__number__subtitle\">+2.5%</span>
\t\t\t\t\t\t\t\t<p class=\"geex-content__visitor-count__number__desc\">Than last week</p>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div id=\"column-chart\"></div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__section geex-content__chat-summary\">
\t\t\t\t\t<div class=\"geex-content__section__header\">
\t\t\t\t\t\t<div class=\"geex-content__section__header__title-part\">
\t\t\t\t\t\t\t<h4 class=\"geex-content__section__header__title\">Chart Summary</h4>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__section__header__content-part\">
\t\t\t\t\t\t\t<div class=\"geex-content__section__header__btn\">
\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__section__header__link\">
\t\t\t\t\t\t\t\tDownload Report
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__section__content\">
\t\t\t\t\t\t<div id=\"pie-chart\"></div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t</div>

\t\t\t<div class=\"geex-content__section geex-content__section--transparent geex-content__review\">
\t\t\t\t<div class=\"geex-content__section__header\">
\t\t\t\t\t<div class=\"geex-content__section__header__title-part\">
\t\t\t\t\t\t<h4 class=\"geex-content__section__header__title\">User Review</h4>
\t\t\t\t\t\t<p class=\"geex-content__section__header__subtitle\">Eum fuga consequuntur ut et.</p>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__section__header__content-part\">
\t\t\t\t\t\t<div class=\"geex-content__section__header__btn geex-content__section__header__swiper-btn\">
\t\t\t\t\t\t\t<div class=\"swiper-btn swiper-btn-prev\">
\t\t\t\t\t\t\t\t<i class=\"uil-arrow-left\"></i>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<div class=\"swiper-btn swiper-btn-next\">
\t\t\t\t\t\t\t\t<i class=\"uil-arrow-right\"></i>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__section__content\">
\t\t\t\t\t<div class=\"swiper-container\">
\t\t\t\t\t\t<div class=\"swiper-wrapper\">
\t\t\t\t\t\t\t<div class=\"swiper-slide\">
\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single\">
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header\">
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__img\">
\t\t\t\t\t\t\t\t\t\t\t<img src=\"assets/img/testimonial/1.svg\" alt=\"User\" />
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__text\">
\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"geex-content__review__single__header__title\">John Doe</h4>
\t\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__header__subtitle\">4 days ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__content\">
\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__content__text\">Ab architecto provident ex accusantium deserunt. Aut aspernatur deleniti sit maiores ut id cum accusamus. Beatae n</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__bottom\">
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn danger-color\">Archive</a>
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn success-color\">Accept</a>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<div class=\"swiper-slide\">
\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single\">
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header\">
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__img\">
\t\t\t\t\t\t\t\t\t\t\t<img src=\"assets/img/testimonial/2.svg\" alt=\"User\" />
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__text\">
\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"geex-content__review__single__header__title\">Kevin Hunt</h4>
\t\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__header__subtitle\">6 days ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__content\">
\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__content__text\">Ab architecto provident ex accusantium deserunt. Aut aspernatur deleniti sit maiores ut id cum accusamus. Beatae n</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__bottom\">
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn danger-color\">Archive</a>
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn success-color\">Accept</a>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<div class=\"swiper-slide\">
\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single\">
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header\">
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__img\">
\t\t\t\t\t\t\t\t\t\t\t<img src=\"assets/img/testimonial/3.svg\" alt=\"User\" />
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__text\">
\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"geex-content__review__single__header__title\">Isabbelle</h4>
\t\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__header__subtitle\">7 days ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__content\">
\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__content__text\">Ab architecto provident ex accusantium deserunt. Aut aspernatur deleniti sit maiores ut id cum accusamus. Beatae n</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__bottom\">
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn success-color\">Publish <i class=\"uil-arrow-right\"></i></a>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<div class=\"swiper-slide\">
\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single\">
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header\">
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__img\">
\t\t\t\t\t\t\t\t\t\t\t<img src=\"assets/img/testimonial/4.svg\" alt=\"User\" />
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__text\">
\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"geex-content__review__single__header__title\">Kevin Hunt</h4>
\t\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__header__subtitle\">6 days ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__content\">
\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__content__text\">Ab architecto provident ex accusantium deserunt. Aut aspernatur deleniti sit maiores ut id cum accusamus. Beatae n</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__bottom\">
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn danger-color\">Archive</a>
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn success-color\">Accept</a>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<div class=\"swiper-slide\">
\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single\">
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header\">
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__img\">
\t\t\t\t\t\t\t\t\t\t\t<img src=\"assets/img/testimonial/2.svg\" alt=\"User\" />
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__header__text\">
\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"geex-content__review__single__header__title\">Isabbelle</h4>
\t\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__header__subtitle\">7 days ago</p>
\t\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__content\">
\t\t\t\t\t\t\t\t\t\t<p class=\"geex-content__review__single__content__text\">Ab architecto provident ex accusantium deserunt. Aut aspernatur deleniti sit maiores ut id cum accusamus. Beatae n</p>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class=\"geex-content__review__single__bottom\">
\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__review__single__btn success-color\">Publish <i class=\"uil-arrow-right\"></i></a>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<!-- Add more slides as needed -->
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t</div>
\t\t</div>

\t\t<div class=\"geex-content__widget\">
\t\t\t<div class=\"geex-content__widget__single\">
\t\t\t\t<div class=\"geex-content__widget__single__header\">
\t\t\t\t\t<h4 class=\"geex-content__widget__single__title\">Server Status</h4>
\t\t\t\t\t<p class=\"geex-content__widget__single__subtitle\">Consectetur et quo dolor vero.</p>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__widget__single__content\">
\t\t\t\t\t<div id=\"stack-chart\"></div>
\t\t\t\t</div>
\t\t\t</div>
\t\t\t<div class=\"geex-content__widget__single\">
\t\t\t\t<div class=\"geex-content__widget__single__header\">
\t\t\t\t\t<h4 class=\"geex-content__widget__single__title\">Recent Problems</h4>
\t\t\t\t\t<p class=\"geex-content__widget__single__subtitle\">Maiores dicta atque dolorem temporibus</p>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__widget__single__content\">
\t\t\t\t\t<div class=\"geex-content__widget__single__cta mb-30\">
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__img\">
\t\t\t\t\t\t\t<img src=\"assets/img/icon/google.svg\" alt=\"google\" />
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__text\">
\t\t\t\t\t\t\t<h4 class=\"geex-content__widget__single__cta__title\">Google</h4>
\t\t\t\t\t\t\t<a href=\"https://www.google.com\" class=\"geex-content__widget__single__cta__link\">https://www.google.com</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__status\">
\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__widget__single__cta__btn danger-bg\">Down</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__widget__single__cta mb-30\">
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__img\">
\t\t\t\t\t\t\t<img src=\"assets/img/icon/facebook.svg\" alt=\"google\" />
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__text\">
\t\t\t\t\t\t\t<h4 class=\"geex-content__widget__single__cta__title\">Facebook</h4>
\t\t\t\t\t\t\t<a href=\"https://www.google.com\" class=\"geex-content__widget__single__cta__link\">https://www.facebook.com</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__status\">
\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__widget__single__cta__btn success-bg\">Stable</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__widget__single__cta\">
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__img\">
\t\t\t\t\t\t\t<img src=\"assets/img/icon/youtube.svg\" alt=\"google\" />
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__text\">
\t\t\t\t\t\t\t<h4 class=\"geex-content__widget__single__cta__title\">Youtube</h4>
\t\t\t\t\t\t\t<a href=\"https://www.google.com\" class=\"geex-content__widget__single__cta__link\">https://www.youtube.com</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"geex-content__widget__single__cta__status\">
\t\t\t\t\t\t\t<a href=\"#\" class=\"geex-content__widget__single__cta__btn warning-bg\">Warning</a>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t</div>
\t\t\t<div class=\"geex-content__widget__single\">
\t\t\t\t<div class=\"geex-content__widget__single__header\">
\t\t\t\t\t<h4 class=\"geex-content__widget__single__title\">Latest Activity</h4>
\t\t\t\t\t<p class=\"geex-content__widget__single__subtitle\">Sit et tempora dicta omnis ab quia quo quo.</p>
\t\t\t\t</div>
\t\t\t\t<div class=\"geex-content__widget__single__content\">
\t\t\t\t\t<div class=\"geex-content__widget__single__timeline\">
\t\t\t\t\t\t<div class=\"geex-content__widget__single__timeline__content\">
\t\t\t\t\t\t<h4 class=\"geex-content__widget__single__timeline__content__title\">January 2nd, 04:35 AM</h4>
\t\t\t\t\t\t<p class=\"geex-content__widget__single__timeline__content__subtitle\">Illum omnis quo illum nisi. Nesciunt est accusamus. Blanditiis nisi quae eum nisi similique. Modi consequuntur totam</p>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__widget__single__timeline\">
\t\t\t\t\t\t<div class=\"geex-content__widget__single__timeline__content\">
\t\t\t\t\t\t<h4 class=\"geex-content__widget__single__timeline__content__title\">January 4th, 06:19 AM</h4>
\t\t\t\t\t\t<p class=\"geex-content__widget__single__timeline__content__subtitle\">Corrupti unde qui molestiae labore ad adipisci veniam perspiciatis quasi. Quae labore vel.</p>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t\t<div class=\"geex-content__widget__single__timeline\">
\t\t\t\t\t\t<div class=\"geex-content__widget__single__timeline__content\">
\t\t\t\t\t\t<h4 class=\"geex-content__widget__single__timeline__content__title\">January 5th, 12:34 AM</h4>
\t\t\t\t\t\t<p class=\"geex-content__widget__single__timeline__content__subtitle\">Maiores doloribus qui. Repellat accusamus minima ipsa ipsam aut debitis quis sit voluptates. Amet necessitatibus non minus quaerat et quis.</p>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t</div>
\t\t</div>
\t</div>

{% endblock %}
", "home/index.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\home\\index.html.twig");
    }
}
