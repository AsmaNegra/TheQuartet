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

/* app/calendar.html.twig */
class __TwigTemplate_95159ad2f5cbf8d90a43f37b2bd446cf extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "app/calendar.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "app/calendar.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "app/calendar.html.twig", 1);
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

        yield "calendar - Geex Dashboard";
        
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

        yield "Calendar";
        
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
<link rel=\"stylesheet\" href=\"https://fullcalendar.io/releases/fullcalendar/3.9.0/fullcalendar.min.css\">
<link rel=\"stylesheet\" href=\"https://code.jquery.com/ui/1.12.1/themes/cupertino/jquery-ui.css\">

<div class=\"geex-content__wrapper\">
    <div class=\"geex-content__section-wrapper\">
        <div class=\"geex-content__section geex-content__section--transparent geex-content__calendar\">
            <button class=\"geex-btn geex-content__calendar__toggle\">
                <i class=\"uil-bars\"></i> Event List
            </button>
            <div class=\"geex-content__calendar__sidebar\">
                <div class=\"geex-content__calendar__sidebar__header\">
                    <button class=\"geex-btn geex-btn--primary geex-btn__add-modal\">
                        <i class=\"uil-plus\"></i> New Event
                    </button>
                </div>

                <div class=\"geex-content__calendar__sidebar__meeting\">
                    <span class=\"geex-content__calendar__sidebar__meeting__label\">My Schedule Today</span>
                    <div class=\"geex-content__calendar__sidebar__meeting__single\">
                        <div class=\"geex-content__calendar__sidebar__meeting__single__text\">
                            <h4 class=\"geex-content__calendar__sidebar__meeting__single__title\">Client Weekly Meeting</h4>
                            <span class=\"geex-content__calendar__sidebar__meeting__single__time\">09:00 AM - 10:00 AM</span>
                        </div>
                        <div class=\"geex-content__calendar__sidebar__meeting__single__tag\">
                            <a href=\"#\" class=\"geex-content__calendar__sidebar__meeting__single__tag__item danger\">
                            Urgent
                            </a>
                            <a href=\"#\" class=\"geex-content__calendar__sidebar__meeting__single__tag__item success\">
                            Face to face
                            </a>
                        </div>
                        <div class=\"geex-content__calendar__sidebar__meeting__single__author\">
                            <div class=\"geex-content__calendar__sidebar__meeting__single__author__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\">
                            </div>
                            <div class=\"geex-content__calendar__sidebar__meeting__single__author__content\">
                                <div class=\"geex-content__calendar__sidebar__meeting__single__author__text\">
                                    <span class=\"geex-content__calendar__sidebar__meeting__single__author__title\">John Braun</span>
                                    <a href=\"#\" class=\"geex-content__calendar__sidebar__meeting__single__author__btn\">View details</a>
                                </div>
                                <div class=\"geex-content__calendar__sidebar__meeting__single__author__icon\">
                                    <a href=\"#\">
                                    <i class=\"uil-angle-right\"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__calendar__sidebar__meeting__single\">
                        <div class=\"geex-content__calendar__sidebar__meeting__single__text\">
                            <h4 class=\"geex-content__calendar__sidebar__meeting__single__title\">Maintenance CenterLoad Balancer</h4>
                            <span class=\"geex-content__calendar__sidebar__meeting__single__time\">09:00 AM - 10:30 AM</span>
                        </div>
                        <div class=\"geex-content__calendar__sidebar__meeting__single__tag\">
                            <a href=\"#\" class=\"geex-content__calendar__sidebar__meeting__single__tag__item primary\">
                            Fixing
                            </a>
                            <a href=\"#\" class=\"geex-content__calendar__sidebar__meeting__single__tag__item warning\">
                            Backend
                            </a>
                        </div>
                    </div>
                    <div class=\"geex-content__calendar__sidebar__meeting__single\">
                        <div class=\"geex-content__calendar__sidebar__meeting__single__text\">
                            <h4 class=\"geex-content__calendar__sidebar__meeting__single__title\">Check Annual Report</h4>
                            <span class=\"geex-content__calendar__sidebar__meeting__single__time\">09:00 AM - 10:30 AM</span>
                        </div>
                        <div class=\"geex-content__calendar__sidebar__meeting__single__tag\">
                            <a href=\"#\" class=\"geex-content__calendar__sidebar__meeting__single__tag__item info\">
                            Report
                            </a>
                        </div>
                    </div>
                </div>

                <div class=\"geex-content__calendar__sidebar__bottom\">
                    <button class=\"geex-btn geex-content__calendar__sidebar__bottom__btn\">View More <i class=\"uil-arrow-right\"></i>
                    </button>
                </div>
            </div>

            <div class=\"tab-content geex-content__calendar__content\">
                <div class=\"geex-content__modal__form\">
                    <div class=\"geex-content__modal__form__header\">
                        <h3 class=\"geex-content__modal__form__title\">Add New Event</h3>
                        <button class=\"geex-content__modal__form__close\">
                            <i class=\"uil-times\"></i>
                        </button>
                    </div>
                    <form class=\"geex-content__modal__form__wrapper\">
                        <div class=\"geex-content__modal__form__item\">
                            <input type=\"text\" name=\"geex-content__modal__form__name\" class=\"geex-content__modal__form__input\" placeholder=\"Event Title\" />
                        </div>
                        <div class=\"geex-content__modal__form__item\">
                            <textarea name=\"geex-content__modal__form__desc\" class=\"geex-content__modal__form__input geex-content__modal__form__input--textarea\" placeholder=\"Event Description\"></textarea>
                        </div>
                        <div class=\"geex-content__modal__form__item\">
                            <button type=\"submit\" class=\"geex-content__modal__form__submit\">Submit</button>
                        </div>
                    </form>
                </div>
                <div id='geex-calendar' class=\"geex-calendar\"></div>
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
        return "app/calendar.html.twig";
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

{% block title %}calendar - Geex Dashboard{% endblock %}

{% block mainHeader %}Calendar{% endblock %}

{% block content %}Form Elements is used to style and format the input field{% endblock %}

{% block body %}

<link rel=\"stylesheet\" href=\"https://fullcalendar.io/releases/fullcalendar/3.9.0/fullcalendar.min.css\">
<link rel=\"stylesheet\" href=\"https://code.jquery.com/ui/1.12.1/themes/cupertino/jquery-ui.css\">

<div class=\"geex-content__wrapper\">
    <div class=\"geex-content__section-wrapper\">
        <div class=\"geex-content__section geex-content__section--transparent geex-content__calendar\">
            <button class=\"geex-btn geex-content__calendar__toggle\">
                <i class=\"uil-bars\"></i> Event List
            </button>
            <div class=\"geex-content__calendar__sidebar\">
                <div class=\"geex-content__calendar__sidebar__header\">
                    <button class=\"geex-btn geex-btn--primary geex-btn__add-modal\">
                        <i class=\"uil-plus\"></i> New Event
                    </button>
                </div>

                <div class=\"geex-content__calendar__sidebar__meeting\">
                    <span class=\"geex-content__calendar__sidebar__meeting__label\">My Schedule Today</span>
                    <div class=\"geex-content__calendar__sidebar__meeting__single\">
                        <div class=\"geex-content__calendar__sidebar__meeting__single__text\">
                            <h4 class=\"geex-content__calendar__sidebar__meeting__single__title\">Client Weekly Meeting</h4>
                            <span class=\"geex-content__calendar__sidebar__meeting__single__time\">09:00 AM - 10:00 AM</span>
                        </div>
                        <div class=\"geex-content__calendar__sidebar__meeting__single__tag\">
                            <a href=\"#\" class=\"geex-content__calendar__sidebar__meeting__single__tag__item danger\">
                            Urgent
                            </a>
                            <a href=\"#\" class=\"geex-content__calendar__sidebar__meeting__single__tag__item success\">
                            Face to face
                            </a>
                        </div>
                        <div class=\"geex-content__calendar__sidebar__meeting__single__author\">
                            <div class=\"geex-content__calendar__sidebar__meeting__single__author__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\">
                            </div>
                            <div class=\"geex-content__calendar__sidebar__meeting__single__author__content\">
                                <div class=\"geex-content__calendar__sidebar__meeting__single__author__text\">
                                    <span class=\"geex-content__calendar__sidebar__meeting__single__author__title\">John Braun</span>
                                    <a href=\"#\" class=\"geex-content__calendar__sidebar__meeting__single__author__btn\">View details</a>
                                </div>
                                <div class=\"geex-content__calendar__sidebar__meeting__single__author__icon\">
                                    <a href=\"#\">
                                    <i class=\"uil-angle-right\"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class=\"geex-content__calendar__sidebar__meeting__single\">
                        <div class=\"geex-content__calendar__sidebar__meeting__single__text\">
                            <h4 class=\"geex-content__calendar__sidebar__meeting__single__title\">Maintenance CenterLoad Balancer</h4>
                            <span class=\"geex-content__calendar__sidebar__meeting__single__time\">09:00 AM - 10:30 AM</span>
                        </div>
                        <div class=\"geex-content__calendar__sidebar__meeting__single__tag\">
                            <a href=\"#\" class=\"geex-content__calendar__sidebar__meeting__single__tag__item primary\">
                            Fixing
                            </a>
                            <a href=\"#\" class=\"geex-content__calendar__sidebar__meeting__single__tag__item warning\">
                            Backend
                            </a>
                        </div>
                    </div>
                    <div class=\"geex-content__calendar__sidebar__meeting__single\">
                        <div class=\"geex-content__calendar__sidebar__meeting__single__text\">
                            <h4 class=\"geex-content__calendar__sidebar__meeting__single__title\">Check Annual Report</h4>
                            <span class=\"geex-content__calendar__sidebar__meeting__single__time\">09:00 AM - 10:30 AM</span>
                        </div>
                        <div class=\"geex-content__calendar__sidebar__meeting__single__tag\">
                            <a href=\"#\" class=\"geex-content__calendar__sidebar__meeting__single__tag__item info\">
                            Report
                            </a>
                        </div>
                    </div>
                </div>

                <div class=\"geex-content__calendar__sidebar__bottom\">
                    <button class=\"geex-btn geex-content__calendar__sidebar__bottom__btn\">View More <i class=\"uil-arrow-right\"></i>
                    </button>
                </div>
            </div>

            <div class=\"tab-content geex-content__calendar__content\">
                <div class=\"geex-content__modal__form\">
                    <div class=\"geex-content__modal__form__header\">
                        <h3 class=\"geex-content__modal__form__title\">Add New Event</h3>
                        <button class=\"geex-content__modal__form__close\">
                            <i class=\"uil-times\"></i>
                        </button>
                    </div>
                    <form class=\"geex-content__modal__form__wrapper\">
                        <div class=\"geex-content__modal__form__item\">
                            <input type=\"text\" name=\"geex-content__modal__form__name\" class=\"geex-content__modal__form__input\" placeholder=\"Event Title\" />
                        </div>
                        <div class=\"geex-content__modal__form__item\">
                            <textarea name=\"geex-content__modal__form__desc\" class=\"geex-content__modal__form__input geex-content__modal__form__input--textarea\" placeholder=\"Event Description\"></textarea>
                        </div>
                        <div class=\"geex-content__modal__form__item\">
                            <button type=\"submit\" class=\"geex-content__modal__form__submit\">Submit</button>
                        </div>
                    </form>
                </div>
                <div id='geex-calendar' class=\"geex-calendar\"></div>
            </div>
        </div>
    </div>
</div>

{% endblock %}
", "app/calendar.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\app\\calendar.html.twig");
    }
}
