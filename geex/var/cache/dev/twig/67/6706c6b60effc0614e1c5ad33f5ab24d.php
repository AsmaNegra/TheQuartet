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

/* app/chat.html.twig */
class __TwigTemplate_a7747adb636892342b67cf5d1bbe143c extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "app/chat.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "app/chat.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "app/chat.html.twig", 1);
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

        yield "Chat - Geex Dashboard";
        
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

        yield "Chat";
        
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
        <div class=\"geex-content__section geex-content__section--transparent geex-content__chat\">
            <button class=\"geex-btn geex-content__chat__toggle\">
                <i class=\"uil-bars\"></i> Chat List
            </button>

            <div class=\"geex-content__chat__sidebar\">
                <div class=\"geex-content__chat__sidebar__searchform\">
                    <div class=\"geex-content__chat__sidebar__searchform__search\">
                        <input type=\"text\" id=\"search10\" placeholder=\"Search\" class=\"geex-content__header__btn\" />
                        <i class=\"uil uil-search\"></i>
                    </div>
                    <button class=\"geex-content__chat__sidebar__searchform__btn\">
                        <i class=\"uil-plus\"></i>
                    </button>
                </div>

                <ul class=\"nav nav-tabs geex-content__chat__sidebar__tab mb-20\" role=\"tablist\">
                    <span class=\"geex-content__chat__sidebar__tab__title\">Pinned Message</span>
                    <li class=\"nav-item\" role=\"presentation\">
                        <a href=\"#\" class=\"nav-link unread active\" id=\"geex-chat-tab-1\" data-bs-toggle=\"tab\" data-bs-target=\"#geex-chat-content-1\" type=\"button\" role=\"tab\" aria-controls=\"geex-chat-content-1\" aria-selected=\"true\">
                            <div class=\"geex-chat-tab-single\">
                                <div class=\"geex-chat-tab-single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"geex-chat-tab-single__status\"></span>
                                </div>
                                <div class=\"geex-chat-tab-single__content\">
                                    <div class=\"geex-chat-tab-single__message\"> 
                                        <h4 class=\"geex-chat-tab-single__title\">Robert Johanson</h4>
                                        <span class=\"geex-chat-tab-single__subtitle\">Hi David, can you send your...</span>
                                    </div>
                                    <div class=\"geex-chat-tab-single__info\">
                                        <span class=\"geex-chat-tab-single__info__time\">2min ago</span>
                                        <span class=\"geex-chat-tab-single__info__count\">2</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class=\"nav-item\" role=\"presentation\">
                        <a href=\"#\" class=\"nav-link\" id=\"geex-chat-tab-2\" data-bs-toggle=\"tab\" data-bs-target=\"#geex-chat-content-2\" type=\"button\" role=\"tab\" aria-controls=\"geex-chat-content-2\" aria-selected=\"true\">
                            <div class=\"geex-chat-tab-single\">
                                <div class=\"geex-chat-tab-single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"geex-chat-tab-single__status active\"></span>
                                </div>
                                <div class=\"geex-chat-tab-single__content\">
                                    <div class=\"geex-chat-tab-single__message\"> 
                                        <h4 class=\"geex-chat-tab-single__title\">Robert Johanson</h4>
                                        <span class=\"geex-chat-tab-single__subtitle\">Hi David, can you send your...</span>
                                    </div>
                                    <div class=\"geex-chat-tab-single__info\">
                                        <svg width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
                                        <path d=\"M23.6181 4.46941C23.4111 4.23957 23.1213 4.10135 22.8124 4.08517C22.5034 4.06898 22.2007 4.17613 21.9708 4.38308L11.1266 14.1422L6.07615 9.09175C5.96853 8.98032 5.83979 8.89144 5.69745 8.83029C5.55512 8.76915 5.40203 8.73697 5.24712 8.73562C5.09221 8.73427 4.93858 8.76379 4.7952 8.82245C4.65182 8.88111 4.52156 8.96774 4.41202 9.07729C4.30248 9.18683 4.21585 9.31709 4.15719 9.46047C4.09853 9.60385 4.06901 9.75747 4.07036 9.91238C4.0717 10.0673 4.10389 10.2204 4.16503 10.3627C4.22617 10.5051 4.31505 10.6338 4.42648 10.7414L10.2598 16.5747C10.4711 16.786 10.7554 16.9081 11.0541 16.9159C11.3528 16.9237 11.6431 16.8166 11.8651 16.6167L23.5318 6.11675C23.7617 5.90971 23.8999 5.61987 23.9161 5.31095C23.9323 5.00204 23.8251 4.69934 23.6181 4.46941Z\" fill=\"#A3A3A3\"/>
                                        <path d=\"M21.9695 11.3831L11.1253 21.1423L6.07482 16.0918C5.85478 15.8793 5.56008 15.7617 5.25419 15.7644C4.94829 15.767 4.65567 15.8897 4.43937 16.106C4.22306 16.3223 4.10036 16.6149 4.0977 16.9208C4.09504 17.2267 4.21264 17.5214 4.42515 17.7415L10.2585 23.5748C10.4698 23.786 10.7541 23.9082 11.0528 23.916C11.3515 23.9238 11.6418 23.8167 11.8638 23.6168L23.5305 13.1168C23.7534 12.908 23.8855 12.6201 23.8985 12.3149C23.9114 12.0098 23.8042 11.7117 23.5999 11.4847C23.3955 11.2578 23.1103 11.12 22.8054 11.101C22.5006 11.082 22.2005 11.1833 21.9695 11.3831Z\" fill=\"#A3A3A3\"/>
                                        </svg>                            
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class=\"nav-item\" role=\"presentation\">
                        <a href=\"#\" class=\"nav-link unread\" id=\"geex-chat-tab-3\" data-bs-toggle=\"tab\" data-bs-target=\"#geex-chat-content-3\" type=\"button\" role=\"tab\" aria-controls=\"geex-chat-task-3\" aria-selected=\"true\">
                            <div class=\"geex-chat-tab-single\">
                                <div class=\"geex-chat-tab-single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"geex-chat-tab-single__status\"></span>
                                </div>
                                <div class=\"geex-chat-tab-single__content\">
                                    <div class=\"geex-chat-tab-single__message\"> 
                                        <h4 class=\"geex-chat-tab-single__title\">Chloe Jess</h4>
                                        <span class=\"geex-chat-tab-single__subtitle\">I have done my task last week..</span>
                                    </div>
                                    <div class=\"geex-chat-tab-single__info\">
                                        <span class=\"geex-chat-tab-single__info__time\">27 ago</span>
                                        <span class=\"geex-chat-tab-single__info__count\">48</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                </ul>

                <ul class=\"nav nav-tabs geex-content__chat__sidebar__tab mb-20\" role=\"tablist\">
                    <span class=\"geex-content__chat__sidebar__tab__title\">Recent Message</span>
                    <li class=\"nav-item\" role=\"presentation\">
                        <a href=\"#\" class=\"nav-link unread\" id=\"geex-chat-tab-4\" data-bs-toggle=\"tab\" data-bs-target=\"#geex-chat-content-4\" type=\"button\" role=\"tab\" aria-controls=\"geex-chat-content-4\" aria-selected=\"true\">
                            <div class=\"geex-chat-tab-single\">
                                <div class=\"geex-chat-tab-single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"geex-chat-tab-single__status\"></span>
                                </div>
                                <div class=\"geex-chat-tab-single__content\">
                                    <div class=\"geex-chat-tab-single__message\"> 
                                        <h4 class=\"geex-chat-tab-single__title\">Robert Johanson</h4>
                                        <span class=\"geex-chat-tab-single__subtitle\">Hi David, can you send your...</span>
                                    </div>
                                    <div class=\"geex-chat-tab-single__info\">
                                        <span class=\"geex-chat-tab-single__info__time\">2min ago</span>
                                        <span class=\"geex-chat-tab-single__info__count\">2</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class=\"nav-item\" role=\"presentation\">
                        <a href=\"#\" class=\"nav-link\" id=\"geex-chat-tab-5\" data-bs-toggle=\"tab\" data-bs-target=\"#geex-chat-content-5\" type=\"button\" role=\"tab\" aria-controls=\"geex-chat-content-5\" aria-selected=\"true\">
                            <div class=\"geex-chat-tab-single\">
                                <div class=\"geex-chat-tab-single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"geex-chat-tab-single__status active\"></span>
                                </div>
                                <div class=\"geex-chat-tab-single__content\">
                                    <div class=\"geex-chat-tab-single__message\"> 
                                        <h4 class=\"geex-chat-tab-single__title\">Robert Johanson</h4>
                                        <span class=\"geex-chat-tab-single__subtitle\">Hi David, can you send your...</span>
                                    </div>
                                    <div class=\"geex-chat-tab-single__info\">
                                        <svg width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
                                        <path d=\"M23.6181 4.46941C23.4111 4.23957 23.1213 4.10135 22.8124 4.08517C22.5034 4.06898 22.2007 4.17613 21.9708 4.38308L11.1266 14.1422L6.07615 9.09175C5.96853 8.98032 5.83979 8.89144 5.69745 8.83029C5.55512 8.76915 5.40203 8.73697 5.24712 8.73562C5.09221 8.73427 4.93858 8.76379 4.7952 8.82245C4.65182 8.88111 4.52156 8.96774 4.41202 9.07729C4.30248 9.18683 4.21585 9.31709 4.15719 9.46047C4.09853 9.60385 4.06901 9.75747 4.07036 9.91238C4.0717 10.0673 4.10389 10.2204 4.16503 10.3627C4.22617 10.5051 4.31505 10.6338 4.42648 10.7414L10.2598 16.5747C10.4711 16.786 10.7554 16.9081 11.0541 16.9159C11.3528 16.9237 11.6431 16.8166 11.8651 16.6167L23.5318 6.11675C23.7617 5.90971 23.8999 5.61987 23.9161 5.31095C23.9323 5.00204 23.8251 4.69934 23.6181 4.46941Z\" fill=\"#A3A3A3\"/>
                                        <path d=\"M21.9695 11.3831L11.1253 21.1423L6.07482 16.0918C5.85478 15.8793 5.56008 15.7617 5.25419 15.7644C4.94829 15.767 4.65567 15.8897 4.43937 16.106C4.22306 16.3223 4.10036 16.6149 4.0977 16.9208C4.09504 17.2267 4.21264 17.5214 4.42515 17.7415L10.2585 23.5748C10.4698 23.786 10.7541 23.9082 11.0528 23.916C11.3515 23.9238 11.6418 23.8167 11.8638 23.6168L23.5305 13.1168C23.7534 12.908 23.8855 12.6201 23.8985 12.3149C23.9114 12.0098 23.8042 11.7117 23.5999 11.4847C23.3955 11.2578 23.1103 11.12 22.8054 11.101C22.5006 11.082 22.2005 11.1833 21.9695 11.3831Z\" fill=\"#A3A3A3\"/>
                                        </svg>                            
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class=\"nav-item\" role=\"presentation\">
                        <a href=\"#\" class=\"nav-link unread\" id=\"geex-chat-tab-6\" data-bs-toggle=\"tab\" data-bs-target=\"#geex-chat-content-6\" type=\"button\" role=\"tab\" aria-controls=\"geex-chat-content-6\" aria-selected=\"true\">
                            <div class=\"geex-chat-tab-single\">
                                <div class=\"geex-chat-tab-single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"geex-chat-tab-single__status\"></span>
                                </div>
                                <div class=\"geex-chat-tab-single__content\">
                                    <div class=\"geex-chat-tab-single__message\"> 
                                        <h4 class=\"geex-chat-tab-single__title\">Chloe Jess</h4>
                                        <span class=\"geex-chat-tab-single__subtitle\">I have done my task last week..</span>
                                    </div>
                                    <div class=\"geex-chat-tab-single__info\">
                                        <span class=\"geex-chat-tab-single__info__time\">27 ago</span>
                                        <span class=\"geex-chat-tab-single__info__count\">48</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>

            <div class=\"tab-content geex-content__chat__content\">
                <div class=\"tab-pane fade show active\" id=\"geex-chat-content-1\" role=\"tabpanel\" aria-labelledby=\"geex-chat-tab-1\">
                    <div class=\"geex-content__chat__content\">
                        <div class=\"geex-content__chat__header\">
                            <div class=\"geex-content__chat__header__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                            </div>
                            <div class=\"geex-content__chat__header__content\">
                                <div class=\"geex-content__chat__header__text\">
                                    <h4 class=\"geex-content__chat__header__title\">Robert Johanson</h4>
                                    <span class=\"geex-content__chat__header__subtitle\">
                                        <i class=\"uil-users-alt\"></i>24 Members
                                    </span>
                                </div>
                                <ul class=\"geex-content__chat__header__filter\">
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__mute-btn\">
                                        <i class=\"uil-bell-slash\"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-search\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content geex-content__header__searchform\">
                                            <input type=\"text\" id=\"search9\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                                            <i class=\"uil uil-search\"></i>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-info-circle\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Status: <span>Active</span><span class=\"status-icon\"></span></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Name: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">James Cameron</a></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Email: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">james@cameron.com</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-ellipsis-v\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Mute Notification</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Background</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Emoji</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Block User</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__list\">
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Ria Tamaguchi</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Hi <a href=\"#\">@chloe</a>, I agree with that schedule. I have accepted your meeting inviataition</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">David Bekam</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__send\">
                            <div class=\"geex-content__chat__send__input\">
                                <input placeholder=\"Type your message...\" name=\"chat1\" id=\"chat1\" value=\"\">
                            </div>
                            <div class=\"geex-content__chat__send__action\">
                                <div class=\"geex-content__chat__action__toggle__content\">
                                    <div class=\"geex-content__chat__send__action__wrap\">
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-camera\"></i>
                                        </div>
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-link\"></i>
                                        </div>
                                    </div>
                                </div>
                                <button class=\"geex-btn geex-content__chat__action__toggle__btn\">
                                    <i class=\"uil-ellipsis-h\"></i>
                                </button>
                                <button type=\"submit\" class=\"btn-send\">
                                    <i class=\"uil uil-message\"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=\"tab-pane fade\" id=\"geex-chat-content-2\" role=\"tabpanel\" aria-labelledby=\"geex-chat-tab-2\">
                    <div class=\"geex-content__chat__content\">
                        <div class=\"geex-content__chat__header\">
                            <div class=\"geex-content__chat__header__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                            </div>
                            <div class=\"geex-content__chat__header__content\">
                                <div class=\"geex-content__chat__header__text\">
                                    <h4 class=\"geex-content__chat__header__title\">Robert Johanson</h4>
                                    <span class=\"geex-content__chat__header__subtitle\">
                                        <i class=\"uil-users-alt\"></i>24 Members
                                    </span>
                                </div>
                                <ul class=\"geex-content__chat__header__filter\">
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__mute-btn\">
                                        <i class=\"uil-bell-slash\"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-search\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content geex-content__header__searchform\">
                                            <input type=\"text\" id=\"search8\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                                            <i class=\"uil uil-search\"></i>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-info-circle\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Status: <span>Active</span><span class=\"status-icon\"></span></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Name: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">James Cameron</a></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Email: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">james@cameron.com</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-ellipsis-v\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Mute Notification</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Background</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Emoji</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Block User</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__list\">
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Ria Tamaguchi</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                    </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Hi <a href=\"#\">@chloe</a>, I agree with that schedule. I have accepted your meeting inviataition</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">David Bekam</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__send\">
                            <div class=\"geex-content__chat__send__input\">
                                <input placeholder=\"Type your message...\" name=\"chat3\" id=\"chat3\" value=\"\">
                            </div>
                            <div class=\"geex-content__chat__send__action\">
                                <div class=\"geex-content__chat__action__toggle__content\">
                                    <div class=\"geex-content__chat__send__action__wrap\">
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-camera\"></i>
                                        </div>
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-link\"></i>
                                        </div>
                                    </div>
                                </div>
                                <button class=\"geex-btn geex-content__chat__action__toggle__btn\">
                                    <i class=\"uil-ellipsis-h\"></i>
                                </button>
                                <button type=\"submit\" class=\"btn-send\">
                                    <i class=\"uil uil-message\"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=\"tab-pane fade\" id=\"geex-chat-content-3\" role=\"tabpanel\" aria-labelledby=\"geex-chat-tab-3\">
                    <div class=\"geex-content__chat__content\">
                        <div class=\"geex-content__chat__header\">
                            <div class=\"geex-content__chat__header__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                            </div>
                            <div class=\"geex-content__chat__header__content\">
                                <div class=\"geex-content__chat__header__text\">
                                    <h4 class=\"geex-content__chat__header__title\">Robert Johanson</h4>
                                    <span class=\"geex-content__chat__header__subtitle\">
                                        <i class=\"uil-users-alt\"></i>24 Members
                                    </span>
                                </div>
                                <ul class=\"geex-content__chat__header__filter\">
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__mute-btn\">
                                        <i class=\"uil-bell-slash\"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-search\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content geex-content__header__searchform\">
                                            <input type=\"text\" id=\"search7\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                                            <i class=\"uil uil-search\"></i>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-info-circle\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Status: <span>Active</span><span class=\"status-icon\"></span></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Name: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">James Cameron</a></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Email: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">james@cameron.com</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-ellipsis-v\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Mute Notification</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Background</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Emoji</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Block User</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__list\">
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Ria Tamaguchi</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Hi <a href=\"#\">@chloe</a>, I agree with that schedule. I have accepted your meeting inviataition</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">David Bekam</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__send\">
                            <div class=\"geex-content__chat__send__input\">
                                <input placeholder=\"Type your message...\" name=\"chat2\" id=\"chat2\" value=\"\">
                            </div>
                            <div class=\"geex-content__chat__send__action\">
                                <div class=\"geex-content__chat__action__toggle__content\">
                                    <div class=\"geex-content__chat__send__action__wrap\">
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-camera\"></i>
                                        </div>
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-link\"></i>
                                        </div>
                                    </div>
                                </div>
                                <button class=\"geex-btn geex-content__chat__action__toggle__btn\">
                                    <i class=\"uil-ellipsis-h\"></i>
                                </button>
                                <button type=\"submit\" class=\"btn-send\">
                                    <i class=\"uil uil-message\"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=\"tab-pane fade\" id=\"geex-chat-content-4\" role=\"tabpanel\" aria-labelledby=\"geex-chat-tab-4\">
                    <div class=\"geex-content__chat__content\">
                        <div class=\"geex-content__chat__header\">
                            <div class=\"geex-content__chat__header__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                            </div>
                            <div class=\"geex-content__chat__header__content\">
                                <div class=\"geex-content__chat__header__text\">
                                    <h4 class=\"geex-content__chat__header__title\">Robert Johanson</h4>
                                    <span class=\"geex-content__chat__header__subtitle\">
                                        <i class=\"uil-users-alt\"></i>24 Members
                                    </span>
                                </div>
                                <ul class=\"geex-content__chat__header__filter\">
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__mute-btn\">
                                        <i class=\"uil-bell-slash\"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-search\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content geex-content__header__searchform\">
                                            <input type=\"text\" id=\"search6\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                                            <i class=\"uil uil-search\"></i>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-info-circle\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Status: <span>Active</span><span class=\"status-icon\"></span></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Name: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">James Cameron</a></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Email: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">james@cameron.com</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-ellipsis-v\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Mute Notification</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Background</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Emoji</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Block User</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__list\">
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Ria Tamaguchi</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Hi <a href=\"#\">@chloe</a>, I agree with that schedule. I have accepted your meeting inviataition</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">David Bekam</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__send\">
                            <div class=\"geex-content__chat__send__input\">
                                <input placeholder=\"Type your message...\" name=\"chat6\" id=\"chat6    \" value=\"\">
                            </div>
                            <div class=\"geex-content__chat__send__action\">
                                <div class=\"geex-content__chat__action__toggle__content\">
                                    <div class=\"geex-content__chat__send__action__wrap\">
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-camera\"></i>
                                        </div>
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-link\"></i>
                                        </div>
                                    </div>
                                </div>
                                <button class=\"geex-btn geex-content__chat__action__toggle__btn\">
                                    <i class=\"uil-ellipsis-h\"></i>
                                </button>
                                <button type=\"submit\" class=\"btn-send\">
                                    <i class=\"uil uil-message\"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=\"tab-pane fade\" id=\"geex-chat-content-5\" role=\"tabpanel\" aria-labelledby=\"geex-chat-tab-5\">
                    <div class=\"geex-content__chat__content\">
                        <div class=\"geex-content__chat__header\">
                            <div class=\"geex-content__chat__header__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                            </div>
                            <div class=\"geex-content__chat__header__content\">
                                <div class=\"geex-content__chat__header__text\">
                                    <h4 class=\"geex-content__chat__header__title\">Robert Johanson</h4>
                                    <span class=\"geex-content__chat__header__subtitle\">
                                        <i class=\"uil-users-alt\"></i>24 Members
                                    </span>
                                </div>
                                <ul class=\"geex-content__chat__header__filter\">
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__mute-btn\">
                                        <i class=\"uil-bell-slash\"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-search\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content geex-content__header__searchform\">
                                            <input type=\"text\" id=\"search5\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                                            <i class=\"uil uil-search\"></i>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-info-circle\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Status: <span>Active</span><span class=\"status-icon\"></span></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Name: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">James Cameron</a></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Email: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">james@cameron.com</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-ellipsis-v\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Mute Notification</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Background</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Emoji</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Block User</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__list\">
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Ria Tamaguchi</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Hi <a href=\"#\">@chloe</a>, I agree with that schedule. I have accepted your meeting inviataition</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">David Bekam</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__send\">
                            <div class=\"geex-content__chat__send__input\">
                                <input placeholder=\"Type your message...\" name=\"chat5\" id=\"chat5\" value=\"\">
                            </div>
                            <div class=\"geex-content__chat__send__action\">
                                <div class=\"geex-content__chat__action__toggle__content\">
                                    <div class=\"geex-content__chat__send__action__wrap\">
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-camera\"></i>
                                        </div>
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-link\"></i>
                                        </div>
                                    </div>
                                </div>
                                <button class=\"geex-btn geex-content__chat__action__toggle__btn\">
                                    <i class=\"uil-ellipsis-h\"></i>
                                </button>
                                <button type=\"submit\" class=\"btn-send\">
                                    <i class=\"uil uil-message\"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=\"tab-pane fade\" id=\"geex-chat-content-6\" role=\"tabpanel\" aria-labelledby=\"geex-chat-tab-6\">
                    <div class=\"geex-content__chat__content\">
                        <div class=\"geex-content__chat__header\">
                            <div class=\"geex-content__chat__header__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                            </div>
                            <div class=\"geex-content__chat__header__content\">
                                <div class=\"geex-content__chat__header__text\">
                                <h4 class=\"geex-content__chat__header__title\">Robert Johanson</h4>
                                <span class=\"geex-content__chat__header__subtitle\">
                                    <i class=\"uil-users-alt\"></i>24 Members
                                </span>
                                </div>
                                <ul class=\"geex-content__chat__header__filter\">
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__mute-btn\">
                                        <i class=\"uil-bell-slash\"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-search\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content geex-content__header__searchform\">
                                            <input type=\"text\" id=\"search2\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                                            <i class=\"uil uil-search\"></i>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-info-circle\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Status: <span>Active</span><span class=\"status-icon\"></span></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Name: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">James Cameron</a></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Email: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">james@cameron.com</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-ellipsis-v\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Mute Notification</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Background</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Emoji</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Block User</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__list\">
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Ria Tamaguchi</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Hi <a href=\"#\">@chloe</a>, I agree with that schedule. I have accepted your meeting inviataition</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">David Bekam</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__send\">
                            <div class=\"geex-content__chat__send__input\">
                                <input placeholder=\"Type your message...\" name=\"chat4\" id=\"chat4\" value=\"\">
                            </div>
                            <div class=\"geex-content__chat__send__action\">
                                <div class=\"geex-content__chat__action__toggle__content\">
                                    <div class=\"geex-content__chat__send__action__wrap\">
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-camera\"></i>
                                        </div>
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-link\"></i>
                                        </div>
                                    </div>
                                </div>
                                <button class=\"geex-btn geex-content__chat__action__toggle__btn\">
                                    <i class=\"uil-ellipsis-h\"></i>
                                </button>
                                <button type=\"submit\" class=\"btn-send\">
                                    <i class=\"uil uil-message\"></i>
                                </button>
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
        return "app/chat.html.twig";
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

{% block title %}Chat - Geex Dashboard{% endblock %}

{% block mainHeader %}Chat{% endblock %}

{% block content %}Form Elements is used to style and format the input field{% endblock %}

{% block body %}

<div class=\"geex-content__wrapper\">
    <div class=\"geex-content__section-wrapper\">
        <div class=\"geex-content__section geex-content__section--transparent geex-content__chat\">
            <button class=\"geex-btn geex-content__chat__toggle\">
                <i class=\"uil-bars\"></i> Chat List
            </button>

            <div class=\"geex-content__chat__sidebar\">
                <div class=\"geex-content__chat__sidebar__searchform\">
                    <div class=\"geex-content__chat__sidebar__searchform__search\">
                        <input type=\"text\" id=\"search10\" placeholder=\"Search\" class=\"geex-content__header__btn\" />
                        <i class=\"uil uil-search\"></i>
                    </div>
                    <button class=\"geex-content__chat__sidebar__searchform__btn\">
                        <i class=\"uil-plus\"></i>
                    </button>
                </div>

                <ul class=\"nav nav-tabs geex-content__chat__sidebar__tab mb-20\" role=\"tablist\">
                    <span class=\"geex-content__chat__sidebar__tab__title\">Pinned Message</span>
                    <li class=\"nav-item\" role=\"presentation\">
                        <a href=\"#\" class=\"nav-link unread active\" id=\"geex-chat-tab-1\" data-bs-toggle=\"tab\" data-bs-target=\"#geex-chat-content-1\" type=\"button\" role=\"tab\" aria-controls=\"geex-chat-content-1\" aria-selected=\"true\">
                            <div class=\"geex-chat-tab-single\">
                                <div class=\"geex-chat-tab-single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"geex-chat-tab-single__status\"></span>
                                </div>
                                <div class=\"geex-chat-tab-single__content\">
                                    <div class=\"geex-chat-tab-single__message\"> 
                                        <h4 class=\"geex-chat-tab-single__title\">Robert Johanson</h4>
                                        <span class=\"geex-chat-tab-single__subtitle\">Hi David, can you send your...</span>
                                    </div>
                                    <div class=\"geex-chat-tab-single__info\">
                                        <span class=\"geex-chat-tab-single__info__time\">2min ago</span>
                                        <span class=\"geex-chat-tab-single__info__count\">2</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class=\"nav-item\" role=\"presentation\">
                        <a href=\"#\" class=\"nav-link\" id=\"geex-chat-tab-2\" data-bs-toggle=\"tab\" data-bs-target=\"#geex-chat-content-2\" type=\"button\" role=\"tab\" aria-controls=\"geex-chat-content-2\" aria-selected=\"true\">
                            <div class=\"geex-chat-tab-single\">
                                <div class=\"geex-chat-tab-single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"geex-chat-tab-single__status active\"></span>
                                </div>
                                <div class=\"geex-chat-tab-single__content\">
                                    <div class=\"geex-chat-tab-single__message\"> 
                                        <h4 class=\"geex-chat-tab-single__title\">Robert Johanson</h4>
                                        <span class=\"geex-chat-tab-single__subtitle\">Hi David, can you send your...</span>
                                    </div>
                                    <div class=\"geex-chat-tab-single__info\">
                                        <svg width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
                                        <path d=\"M23.6181 4.46941C23.4111 4.23957 23.1213 4.10135 22.8124 4.08517C22.5034 4.06898 22.2007 4.17613 21.9708 4.38308L11.1266 14.1422L6.07615 9.09175C5.96853 8.98032 5.83979 8.89144 5.69745 8.83029C5.55512 8.76915 5.40203 8.73697 5.24712 8.73562C5.09221 8.73427 4.93858 8.76379 4.7952 8.82245C4.65182 8.88111 4.52156 8.96774 4.41202 9.07729C4.30248 9.18683 4.21585 9.31709 4.15719 9.46047C4.09853 9.60385 4.06901 9.75747 4.07036 9.91238C4.0717 10.0673 4.10389 10.2204 4.16503 10.3627C4.22617 10.5051 4.31505 10.6338 4.42648 10.7414L10.2598 16.5747C10.4711 16.786 10.7554 16.9081 11.0541 16.9159C11.3528 16.9237 11.6431 16.8166 11.8651 16.6167L23.5318 6.11675C23.7617 5.90971 23.8999 5.61987 23.9161 5.31095C23.9323 5.00204 23.8251 4.69934 23.6181 4.46941Z\" fill=\"#A3A3A3\"/>
                                        <path d=\"M21.9695 11.3831L11.1253 21.1423L6.07482 16.0918C5.85478 15.8793 5.56008 15.7617 5.25419 15.7644C4.94829 15.767 4.65567 15.8897 4.43937 16.106C4.22306 16.3223 4.10036 16.6149 4.0977 16.9208C4.09504 17.2267 4.21264 17.5214 4.42515 17.7415L10.2585 23.5748C10.4698 23.786 10.7541 23.9082 11.0528 23.916C11.3515 23.9238 11.6418 23.8167 11.8638 23.6168L23.5305 13.1168C23.7534 12.908 23.8855 12.6201 23.8985 12.3149C23.9114 12.0098 23.8042 11.7117 23.5999 11.4847C23.3955 11.2578 23.1103 11.12 22.8054 11.101C22.5006 11.082 22.2005 11.1833 21.9695 11.3831Z\" fill=\"#A3A3A3\"/>
                                        </svg>                            
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class=\"nav-item\" role=\"presentation\">
                        <a href=\"#\" class=\"nav-link unread\" id=\"geex-chat-tab-3\" data-bs-toggle=\"tab\" data-bs-target=\"#geex-chat-content-3\" type=\"button\" role=\"tab\" aria-controls=\"geex-chat-task-3\" aria-selected=\"true\">
                            <div class=\"geex-chat-tab-single\">
                                <div class=\"geex-chat-tab-single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"geex-chat-tab-single__status\"></span>
                                </div>
                                <div class=\"geex-chat-tab-single__content\">
                                    <div class=\"geex-chat-tab-single__message\"> 
                                        <h4 class=\"geex-chat-tab-single__title\">Chloe Jess</h4>
                                        <span class=\"geex-chat-tab-single__subtitle\">I have done my task last week..</span>
                                    </div>
                                    <div class=\"geex-chat-tab-single__info\">
                                        <span class=\"geex-chat-tab-single__info__time\">27 ago</span>
                                        <span class=\"geex-chat-tab-single__info__count\">48</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                </ul>

                <ul class=\"nav nav-tabs geex-content__chat__sidebar__tab mb-20\" role=\"tablist\">
                    <span class=\"geex-content__chat__sidebar__tab__title\">Recent Message</span>
                    <li class=\"nav-item\" role=\"presentation\">
                        <a href=\"#\" class=\"nav-link unread\" id=\"geex-chat-tab-4\" data-bs-toggle=\"tab\" data-bs-target=\"#geex-chat-content-4\" type=\"button\" role=\"tab\" aria-controls=\"geex-chat-content-4\" aria-selected=\"true\">
                            <div class=\"geex-chat-tab-single\">
                                <div class=\"geex-chat-tab-single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"geex-chat-tab-single__status\"></span>
                                </div>
                                <div class=\"geex-chat-tab-single__content\">
                                    <div class=\"geex-chat-tab-single__message\"> 
                                        <h4 class=\"geex-chat-tab-single__title\">Robert Johanson</h4>
                                        <span class=\"geex-chat-tab-single__subtitle\">Hi David, can you send your...</span>
                                    </div>
                                    <div class=\"geex-chat-tab-single__info\">
                                        <span class=\"geex-chat-tab-single__info__time\">2min ago</span>
                                        <span class=\"geex-chat-tab-single__info__count\">2</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class=\"nav-item\" role=\"presentation\">
                        <a href=\"#\" class=\"nav-link\" id=\"geex-chat-tab-5\" data-bs-toggle=\"tab\" data-bs-target=\"#geex-chat-content-5\" type=\"button\" role=\"tab\" aria-controls=\"geex-chat-content-5\" aria-selected=\"true\">
                            <div class=\"geex-chat-tab-single\">
                                <div class=\"geex-chat-tab-single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"geex-chat-tab-single__status active\"></span>
                                </div>
                                <div class=\"geex-chat-tab-single__content\">
                                    <div class=\"geex-chat-tab-single__message\"> 
                                        <h4 class=\"geex-chat-tab-single__title\">Robert Johanson</h4>
                                        <span class=\"geex-chat-tab-single__subtitle\">Hi David, can you send your...</span>
                                    </div>
                                    <div class=\"geex-chat-tab-single__info\">
                                        <svg width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
                                        <path d=\"M23.6181 4.46941C23.4111 4.23957 23.1213 4.10135 22.8124 4.08517C22.5034 4.06898 22.2007 4.17613 21.9708 4.38308L11.1266 14.1422L6.07615 9.09175C5.96853 8.98032 5.83979 8.89144 5.69745 8.83029C5.55512 8.76915 5.40203 8.73697 5.24712 8.73562C5.09221 8.73427 4.93858 8.76379 4.7952 8.82245C4.65182 8.88111 4.52156 8.96774 4.41202 9.07729C4.30248 9.18683 4.21585 9.31709 4.15719 9.46047C4.09853 9.60385 4.06901 9.75747 4.07036 9.91238C4.0717 10.0673 4.10389 10.2204 4.16503 10.3627C4.22617 10.5051 4.31505 10.6338 4.42648 10.7414L10.2598 16.5747C10.4711 16.786 10.7554 16.9081 11.0541 16.9159C11.3528 16.9237 11.6431 16.8166 11.8651 16.6167L23.5318 6.11675C23.7617 5.90971 23.8999 5.61987 23.9161 5.31095C23.9323 5.00204 23.8251 4.69934 23.6181 4.46941Z\" fill=\"#A3A3A3\"/>
                                        <path d=\"M21.9695 11.3831L11.1253 21.1423L6.07482 16.0918C5.85478 15.8793 5.56008 15.7617 5.25419 15.7644C4.94829 15.767 4.65567 15.8897 4.43937 16.106C4.22306 16.3223 4.10036 16.6149 4.0977 16.9208C4.09504 17.2267 4.21264 17.5214 4.42515 17.7415L10.2585 23.5748C10.4698 23.786 10.7541 23.9082 11.0528 23.916C11.3515 23.9238 11.6418 23.8167 11.8638 23.6168L23.5305 13.1168C23.7534 12.908 23.8855 12.6201 23.8985 12.3149C23.9114 12.0098 23.8042 11.7117 23.5999 11.4847C23.3955 11.2578 23.1103 11.12 22.8054 11.101C22.5006 11.082 22.2005 11.1833 21.9695 11.3831Z\" fill=\"#A3A3A3\"/>
                                        </svg>                            
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class=\"nav-item\" role=\"presentation\">
                        <a href=\"#\" class=\"nav-link unread\" id=\"geex-chat-tab-6\" data-bs-toggle=\"tab\" data-bs-target=\"#geex-chat-content-6\" type=\"button\" role=\"tab\" aria-controls=\"geex-chat-content-6\" aria-selected=\"true\">
                            <div class=\"geex-chat-tab-single\">
                                <div class=\"geex-chat-tab-single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"geex-chat-tab-single__status\"></span>
                                </div>
                                <div class=\"geex-chat-tab-single__content\">
                                    <div class=\"geex-chat-tab-single__message\"> 
                                        <h4 class=\"geex-chat-tab-single__title\">Chloe Jess</h4>
                                        <span class=\"geex-chat-tab-single__subtitle\">I have done my task last week..</span>
                                    </div>
                                    <div class=\"geex-chat-tab-single__info\">
                                        <span class=\"geex-chat-tab-single__info__time\">27 ago</span>
                                        <span class=\"geex-chat-tab-single__info__count\">48</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>

            <div class=\"tab-content geex-content__chat__content\">
                <div class=\"tab-pane fade show active\" id=\"geex-chat-content-1\" role=\"tabpanel\" aria-labelledby=\"geex-chat-tab-1\">
                    <div class=\"geex-content__chat__content\">
                        <div class=\"geex-content__chat__header\">
                            <div class=\"geex-content__chat__header__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                            </div>
                            <div class=\"geex-content__chat__header__content\">
                                <div class=\"geex-content__chat__header__text\">
                                    <h4 class=\"geex-content__chat__header__title\">Robert Johanson</h4>
                                    <span class=\"geex-content__chat__header__subtitle\">
                                        <i class=\"uil-users-alt\"></i>24 Members
                                    </span>
                                </div>
                                <ul class=\"geex-content__chat__header__filter\">
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__mute-btn\">
                                        <i class=\"uil-bell-slash\"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-search\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content geex-content__header__searchform\">
                                            <input type=\"text\" id=\"search9\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                                            <i class=\"uil uil-search\"></i>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-info-circle\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Status: <span>Active</span><span class=\"status-icon\"></span></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Name: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">James Cameron</a></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Email: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">james@cameron.com</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-ellipsis-v\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Mute Notification</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Background</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Emoji</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Block User</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__list\">
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Ria Tamaguchi</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Hi <a href=\"#\">@chloe</a>, I agree with that schedule. I have accepted your meeting inviataition</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">David Bekam</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__send\">
                            <div class=\"geex-content__chat__send__input\">
                                <input placeholder=\"Type your message...\" name=\"chat1\" id=\"chat1\" value=\"\">
                            </div>
                            <div class=\"geex-content__chat__send__action\">
                                <div class=\"geex-content__chat__action__toggle__content\">
                                    <div class=\"geex-content__chat__send__action__wrap\">
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-camera\"></i>
                                        </div>
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-link\"></i>
                                        </div>
                                    </div>
                                </div>
                                <button class=\"geex-btn geex-content__chat__action__toggle__btn\">
                                    <i class=\"uil-ellipsis-h\"></i>
                                </button>
                                <button type=\"submit\" class=\"btn-send\">
                                    <i class=\"uil uil-message\"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=\"tab-pane fade\" id=\"geex-chat-content-2\" role=\"tabpanel\" aria-labelledby=\"geex-chat-tab-2\">
                    <div class=\"geex-content__chat__content\">
                        <div class=\"geex-content__chat__header\">
                            <div class=\"geex-content__chat__header__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                            </div>
                            <div class=\"geex-content__chat__header__content\">
                                <div class=\"geex-content__chat__header__text\">
                                    <h4 class=\"geex-content__chat__header__title\">Robert Johanson</h4>
                                    <span class=\"geex-content__chat__header__subtitle\">
                                        <i class=\"uil-users-alt\"></i>24 Members
                                    </span>
                                </div>
                                <ul class=\"geex-content__chat__header__filter\">
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__mute-btn\">
                                        <i class=\"uil-bell-slash\"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-search\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content geex-content__header__searchform\">
                                            <input type=\"text\" id=\"search8\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                                            <i class=\"uil uil-search\"></i>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-info-circle\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Status: <span>Active</span><span class=\"status-icon\"></span></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Name: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">James Cameron</a></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Email: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">james@cameron.com</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-ellipsis-v\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Mute Notification</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Background</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Emoji</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Block User</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__list\">
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Ria Tamaguchi</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                    </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Hi <a href=\"#\">@chloe</a>, I agree with that schedule. I have accepted your meeting inviataition</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">David Bekam</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__send\">
                            <div class=\"geex-content__chat__send__input\">
                                <input placeholder=\"Type your message...\" name=\"chat3\" id=\"chat3\" value=\"\">
                            </div>
                            <div class=\"geex-content__chat__send__action\">
                                <div class=\"geex-content__chat__action__toggle__content\">
                                    <div class=\"geex-content__chat__send__action__wrap\">
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-camera\"></i>
                                        </div>
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-link\"></i>
                                        </div>
                                    </div>
                                </div>
                                <button class=\"geex-btn geex-content__chat__action__toggle__btn\">
                                    <i class=\"uil-ellipsis-h\"></i>
                                </button>
                                <button type=\"submit\" class=\"btn-send\">
                                    <i class=\"uil uil-message\"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=\"tab-pane fade\" id=\"geex-chat-content-3\" role=\"tabpanel\" aria-labelledby=\"geex-chat-tab-3\">
                    <div class=\"geex-content__chat__content\">
                        <div class=\"geex-content__chat__header\">
                            <div class=\"geex-content__chat__header__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                            </div>
                            <div class=\"geex-content__chat__header__content\">
                                <div class=\"geex-content__chat__header__text\">
                                    <h4 class=\"geex-content__chat__header__title\">Robert Johanson</h4>
                                    <span class=\"geex-content__chat__header__subtitle\">
                                        <i class=\"uil-users-alt\"></i>24 Members
                                    </span>
                                </div>
                                <ul class=\"geex-content__chat__header__filter\">
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__mute-btn\">
                                        <i class=\"uil-bell-slash\"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-search\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content geex-content__header__searchform\">
                                            <input type=\"text\" id=\"search7\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                                            <i class=\"uil uil-search\"></i>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-info-circle\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Status: <span>Active</span><span class=\"status-icon\"></span></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Name: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">James Cameron</a></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Email: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">james@cameron.com</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-ellipsis-v\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Mute Notification</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Background</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Emoji</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Block User</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__list\">
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Ria Tamaguchi</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Hi <a href=\"#\">@chloe</a>, I agree with that schedule. I have accepted your meeting inviataition</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">David Bekam</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__send\">
                            <div class=\"geex-content__chat__send__input\">
                                <input placeholder=\"Type your message...\" name=\"chat2\" id=\"chat2\" value=\"\">
                            </div>
                            <div class=\"geex-content__chat__send__action\">
                                <div class=\"geex-content__chat__action__toggle__content\">
                                    <div class=\"geex-content__chat__send__action__wrap\">
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-camera\"></i>
                                        </div>
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-link\"></i>
                                        </div>
                                    </div>
                                </div>
                                <button class=\"geex-btn geex-content__chat__action__toggle__btn\">
                                    <i class=\"uil-ellipsis-h\"></i>
                                </button>
                                <button type=\"submit\" class=\"btn-send\">
                                    <i class=\"uil uil-message\"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=\"tab-pane fade\" id=\"geex-chat-content-4\" role=\"tabpanel\" aria-labelledby=\"geex-chat-tab-4\">
                    <div class=\"geex-content__chat__content\">
                        <div class=\"geex-content__chat__header\">
                            <div class=\"geex-content__chat__header__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                            </div>
                            <div class=\"geex-content__chat__header__content\">
                                <div class=\"geex-content__chat__header__text\">
                                    <h4 class=\"geex-content__chat__header__title\">Robert Johanson</h4>
                                    <span class=\"geex-content__chat__header__subtitle\">
                                        <i class=\"uil-users-alt\"></i>24 Members
                                    </span>
                                </div>
                                <ul class=\"geex-content__chat__header__filter\">
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__mute-btn\">
                                        <i class=\"uil-bell-slash\"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-search\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content geex-content__header__searchform\">
                                            <input type=\"text\" id=\"search6\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                                            <i class=\"uil uil-search\"></i>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-info-circle\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Status: <span>Active</span><span class=\"status-icon\"></span></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Name: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">James Cameron</a></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Email: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">james@cameron.com</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-ellipsis-v\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Mute Notification</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Background</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Emoji</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Block User</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__list\">
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Ria Tamaguchi</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Hi <a href=\"#\">@chloe</a>, I agree with that schedule. I have accepted your meeting inviataition</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">David Bekam</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__send\">
                            <div class=\"geex-content__chat__send__input\">
                                <input placeholder=\"Type your message...\" name=\"chat6\" id=\"chat6    \" value=\"\">
                            </div>
                            <div class=\"geex-content__chat__send__action\">
                                <div class=\"geex-content__chat__action__toggle__content\">
                                    <div class=\"geex-content__chat__send__action__wrap\">
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-camera\"></i>
                                        </div>
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-link\"></i>
                                        </div>
                                    </div>
                                </div>
                                <button class=\"geex-btn geex-content__chat__action__toggle__btn\">
                                    <i class=\"uil-ellipsis-h\"></i>
                                </button>
                                <button type=\"submit\" class=\"btn-send\">
                                    <i class=\"uil uil-message\"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=\"tab-pane fade\" id=\"geex-chat-content-5\" role=\"tabpanel\" aria-labelledby=\"geex-chat-tab-5\">
                    <div class=\"geex-content__chat__content\">
                        <div class=\"geex-content__chat__header\">
                            <div class=\"geex-content__chat__header__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                            </div>
                            <div class=\"geex-content__chat__header__content\">
                                <div class=\"geex-content__chat__header__text\">
                                    <h4 class=\"geex-content__chat__header__title\">Robert Johanson</h4>
                                    <span class=\"geex-content__chat__header__subtitle\">
                                        <i class=\"uil-users-alt\"></i>24 Members
                                    </span>
                                </div>
                                <ul class=\"geex-content__chat__header__filter\">
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__mute-btn\">
                                        <i class=\"uil-bell-slash\"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-search\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content geex-content__header__searchform\">
                                            <input type=\"text\" id=\"search5\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                                            <i class=\"uil uil-search\"></i>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-info-circle\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Status: <span>Active</span><span class=\"status-icon\"></span></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Name: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">James Cameron</a></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Email: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">james@cameron.com</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-ellipsis-v\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Mute Notification</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Background</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Emoji</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Block User</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__list\">
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Ria Tamaguchi</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Hi <a href=\"#\">@chloe</a>, I agree with that schedule. I have accepted your meeting inviataition</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">David Bekam</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__send\">
                            <div class=\"geex-content__chat__send__input\">
                                <input placeholder=\"Type your message...\" name=\"chat5\" id=\"chat5\" value=\"\">
                            </div>
                            <div class=\"geex-content__chat__send__action\">
                                <div class=\"geex-content__chat__action__toggle__content\">
                                    <div class=\"geex-content__chat__send__action__wrap\">
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-camera\"></i>
                                        </div>
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-link\"></i>
                                        </div>
                                    </div>
                                </div>
                                <button class=\"geex-btn geex-content__chat__action__toggle__btn\">
                                    <i class=\"uil-ellipsis-h\"></i>
                                </button>
                                <button type=\"submit\" class=\"btn-send\">
                                    <i class=\"uil uil-message\"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=\"tab-pane fade\" id=\"geex-chat-content-6\" role=\"tabpanel\" aria-labelledby=\"geex-chat-tab-6\">
                    <div class=\"geex-content__chat__content\">
                        <div class=\"geex-content__chat__header\">
                            <div class=\"geex-content__chat__header__img\">
                                <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                            </div>
                            <div class=\"geex-content__chat__header__content\">
                                <div class=\"geex-content__chat__header__text\">
                                <h4 class=\"geex-content__chat__header__title\">Robert Johanson</h4>
                                <span class=\"geex-content__chat__header__subtitle\">
                                    <i class=\"uil-users-alt\"></i>24 Members
                                </span>
                                </div>
                                <ul class=\"geex-content__chat__header__filter\">
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__mute-btn\">
                                        <i class=\"uil-bell-slash\"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-search\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content geex-content__header__searchform\">
                                            <input type=\"text\" id=\"search2\" placeholder=\"Search\" class=\"geex-content__header__btn\">
                                            <i class=\"uil uil-search\"></i>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-info-circle\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Status: <span>Active</span><span class=\"status-icon\"></span></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Name: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">James Cameron</a></li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">Email: <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">james@cameron.com</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href=\"#\" class=\"geex-content__chat__header__filter__btn\">
                                            <i class=\"uil-ellipsis-v\"></i>
                                        </a>
                                        <div class=\"geex-content__chat__header__filter__content\">
                                            <ul class=\"geex-content__chat__header__filter__content__list\">
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Mute Notification</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Background</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Change Emoji</a>
                                                </li>
                                                <li class=\"geex-content__chat__header__filter__content__list__item\">
                                                    <a href=\"#\" class=\"geex-content__chat__header__filter__content__list__link\">Block User</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__list\">
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Ria Tamaguchi</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Hi <a href=\"#\">@chloe</a>, I agree with that schedule. I have accepted your meeting inviataition</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">David Bekam</span>
                                    <span class=\"geex-content__chat__list__single__msg\">Hi everyone! Let’s start our discussion now about kick off meeting next week.</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
            
                            <div class=\"geex-content__chat__list__single active\">
                                <div class=\"geex-content__chat__list__single__img\">
                                    <img src=\"assets/img/avatar/chat/1.svg\" alt=\"avatar\" />
                                    <span class=\"active\"></span>
                                </div>
                                <div class=\"geex-content__chat__list__single__text\">
                                    <span class=\"geex-content__chat__list__single__title\">Joe Takeshi</span>
                                    <span class=\"geex-content__chat__list__single__msg latest\">Is everyone ok about that schedule?</span>
                                </div>
                            </div>
                        </div>
        
                        <div class=\"geex-content__chat__send\">
                            <div class=\"geex-content__chat__send__input\">
                                <input placeholder=\"Type your message...\" name=\"chat4\" id=\"chat4\" value=\"\">
                            </div>
                            <div class=\"geex-content__chat__send__action\">
                                <div class=\"geex-content__chat__action__toggle__content\">
                                    <div class=\"geex-content__chat__send__action__wrap\">
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-camera\"></i>
                                        </div>
                                        <div class=\"geex-content__chat__send__action__single\">
                                            <input type=\"file\">
                                            <i class=\"uil uil-link\"></i>
                                        </div>
                                    </div>
                                </div>
                                <button class=\"geex-btn geex-content__chat__action__toggle__btn\">
                                    <i class=\"uil-ellipsis-h\"></i>
                                </button>
                                <button type=\"submit\" class=\"btn-send\">
                                    <i class=\"uil uil-message\"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

{% endblock %}
", "app/chat.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\app\\chat.html.twig");
    }
}
