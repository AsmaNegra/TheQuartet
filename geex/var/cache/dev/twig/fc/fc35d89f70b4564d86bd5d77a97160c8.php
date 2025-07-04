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

/* home/index4.html.twig */
class __TwigTemplate_d46780836094057e325d62929488ba2f extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "home/index4.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "home/index4.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "home/index4.html.twig", 1);
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

        yield "Invoicing - Geex Dashboard";
        
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

        yield "Invoicing";
        
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
<div class=\"geex-content__wrapper\">
    <div class=\"geex-content__section-wrapper\">
        <div class=\"geex-content__summary\">
            <div class=\"geex-content__summary__count\">
                <div class=\"geex-content__summary__count__single primay-bg\">
                    <div class=\"geex-content__summary__count__single__content\">
                        <h4 class=\"geex-content__summary__count__single__title\">982</h4>
                        <p class=\"geex-content__summary__count__single__subtitle\">Invoice Sent</p>
                    </div>
                    <div class=\"geex-content__summary__count__single__icon\">
                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"32\" height=\"32\" viewBox=\"0 0 32 32\" fill=\"none\">
                            <path d=\"M26.9908 5.10791C26.7542 4.84524 26.4229 4.68728 26.0699 4.66878C25.7168 4.65027 25.3709 4.77274 25.1081 5.00925L12.7148 16.1626L6.94277 10.3906C6.81978 10.2632 6.67265 10.1617 6.50998 10.0918C6.34731 10.0219 6.17235 9.98512 5.99531 9.98358C5.81827 9.98204 5.6427 10.0158 5.47884 10.0828C5.31497 10.1499 5.16611 10.2489 5.04091 10.3741C4.91572 10.4992 4.81672 10.6481 4.74968 10.812C4.68264 10.9758 4.6489 11.1514 4.65044 11.3285C4.65198 11.5055 4.68876 11.6804 4.75864 11.8431C4.82852 12.0058 4.93009 12.1529 5.05744 12.2759L11.7241 18.9426C11.9656 19.184 12.2905 19.3235 12.6319 19.3325C12.9732 19.3414 13.305 19.219 13.5588 18.9906L26.8921 6.99058C27.1548 6.75397 27.3127 6.42272 27.3312 6.06968C27.3498 5.71663 27.2273 5.37069 26.9908 5.10791Z\" fill=\"#464255\"/>
                            <path d=\"M25.1085 13.0093L12.7152 24.1626L6.94321 18.3906C6.69174 18.1478 6.35494 18.0134 6.00534 18.0164C5.65575 18.0195 5.32133 18.1597 5.07412 18.4069C4.82691 18.6541 4.68668 18.9885 4.68364 19.3381C4.68061 19.6877 4.815 20.0245 5.05788 20.276L11.7245 26.9426C11.966 27.1841 12.291 27.3236 12.6323 27.3325C12.9737 27.3415 13.3054 27.2191 13.5592 26.9906L26.8925 14.9906C27.1473 14.752 27.2983 14.423 27.3131 14.0742C27.3279 13.7255 27.2054 13.3848 26.9718 13.1254C26.7383 12.866 26.4123 12.7086 26.0639 12.6868C25.7155 12.6651 25.3725 12.7809 25.1085 13.0093Z\" fill=\"#464255\"/>
                          </svg>
                    </div>
                </div>
                <div class=\"geex-content__summary__count__single danger-bg\">
                    <div class=\"geex-content__summary__count__single__content\">
                        <h4 class=\"geex-content__summary__count__single__title\">45</h4>
                        <p class=\"geex-content__summary__count__single__subtitle\">Pending Invoice</p>
                    </div>
                    <div class=\"geex-content__summary__count__single__icon\">
                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"32\" height=\"32\" viewBox=\"0 0 32 32\" fill=\"none\">
                            <path d=\"M15.9997 1.33321C13.0989 1.33321 10.2632 2.19339 7.85132 3.80498C5.4394 5.41658 3.55953 7.7072 2.44945 10.3872C1.33936 13.0672 1.04891 16.0161 1.61483 18.8612C2.18075 21.7063 3.57761 24.3196 5.62878 26.3708C7.67995 28.4219 10.2933 29.8188 13.1384 30.3847C15.9834 30.9506 18.9324 30.6602 21.6124 29.5501C24.2924 28.44 26.583 26.5602 28.1946 24.1482C29.8062 21.7363 30.6664 18.9007 30.6664 15.9999C30.6618 12.1114 29.1151 8.38358 26.3655 5.63404C23.616 2.8845 19.8881 1.33779 15.9997 1.33321ZM15.9997 27.9999C13.6263 27.9999 11.3062 27.2961 9.33284 25.9775C7.35945 24.6589 5.82138 22.7848 4.91313 20.5921C4.00488 18.3994 3.76724 15.9866 4.23026 13.6588C4.69328 11.331 5.83617 9.19282 7.5144 7.51459C9.19263 5.83636 11.3308 4.69347 13.6586 4.23045C15.9864 3.76743 18.3992 4.00507 20.5919 4.91332C22.7846 5.82157 24.6587 7.35964 25.9773 9.33303C27.2959 11.3064 27.9997 13.6265 27.9997 15.9999C27.9958 19.1813 26.7303 22.2313 24.4807 24.4809C22.2311 26.7305 19.1811 27.996 15.9997 27.9999Z\" fill=\"#464255\"/>
                            <path d=\"M18.9433 7.55344C18.1839 7.05351 17.3108 6.75286 16.4046 6.67923C15.4984 6.60559 14.5882 6.76134 13.758 7.13211C12.8218 7.54836 12.0291 8.23143 11.4792 9.09587C10.9292 9.96031 10.6463 10.9677 10.666 11.9921V12.0001C10.6671 12.3537 10.8086 12.6925 11.0594 12.9417C11.3101 13.191 11.6497 13.3305 12.0033 13.3294C12.357 13.3284 12.6957 13.1869 12.945 12.9361C13.1943 12.6853 13.3337 12.3457 13.3327 11.9921C13.3191 11.4931 13.4503 11.0009 13.7106 10.5749C13.9709 10.149 14.3491 9.80763 14.7993 9.59211C15.224 9.3921 15.6928 9.30424 16.161 9.33692C16.6292 9.3696 17.0813 9.52172 17.474 9.77878C17.8246 10.0106 18.1154 10.3221 18.3227 10.6877C18.53 11.0533 18.6479 11.4627 18.6669 11.8826C18.6859 12.3025 18.6054 12.7209 18.4319 13.1037C18.2584 13.4865 17.9969 13.8229 17.6687 14.0854C16.756 14.7825 16.0122 15.6761 15.4923 16.7001C14.9725 17.7241 14.6901 18.852 14.666 20.0001C14.6666 20.1752 14.7017 20.3485 14.7693 20.51C14.8369 20.6715 14.9356 20.8182 15.0598 20.9416C15.1841 21.0649 15.3314 21.1626 15.4934 21.2291C15.6554 21.2955 15.8289 21.3294 16.004 21.3288C16.1791 21.3282 16.3524 21.2931 16.5139 21.2255C16.6754 21.1579 16.8221 21.0592 16.9454 20.935C17.0688 20.8107 17.1665 20.6634 17.233 20.5014C17.2994 20.3394 17.3333 20.1659 17.3327 19.9908C17.3582 19.2435 17.5512 18.5115 17.8974 17.8488C18.2435 17.186 18.734 16.6094 19.3327 16.1614C19.9879 15.6361 20.5098 14.9634 20.8559 14.1982C21.202 13.4329 21.3624 12.5968 21.3242 11.7578C21.286 10.9188 21.0502 10.1008 20.636 9.37015C20.2218 8.63954 19.6409 8.01708 18.9407 7.55344H18.9433Z\" fill=\"#464255\"/>
                            <path d=\"M16.0003 25.3335C16.7367 25.3335 17.3337 24.7365 17.3337 24.0001C17.3337 23.2637 16.7367 22.6668 16.0003 22.6668C15.2639 22.6668 14.667 23.2637 14.667 24.0001C14.667 24.7365 15.2639 25.3335 16.0003 25.3335Z\" fill=\"#464255\"/>
                        </svg>
                    </div>
                </div>
                <div class=\"geex-content__summary__count__single success-bg\">
                    <div class=\"geex-content__summary__count__single__content\">
                        <h4 class=\"geex-content__summary__count__single__title\">73</h4>
                        <p class=\"geex-content__summary__count__single__subtitle\">Paid Invoice</p>
                    </div>
                    <div class=\"geex-content__summary__count__single__icon\">
                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"32\" height=\"32\" viewBox=\"0 0 32 32\" fill=\"none\">
                            <path d=\"M15.9997 1.33335C13.0989 1.33335 10.2632 2.19353 7.85132 3.80513C5.4394 5.41672 3.55953 7.70734 2.44945 10.3873C1.33936 13.0673 1.04891 16.0163 1.61483 18.8613C2.18075 21.7064 3.57761 24.3197 5.62878 26.3709C7.67995 28.4221 10.2933 29.8189 13.1384 30.3849C15.9834 30.9508 18.9324 30.6603 21.6124 29.5502C24.2924 28.4402 26.583 26.5603 28.1946 24.1484C29.8062 21.7365 30.6664 18.9008 30.6664 16C30.6618 12.1116 29.1151 8.38372 26.3655 5.63418C23.616 2.88464 19.8881 1.33793 15.9997 1.33335ZM15.9997 28C13.6263 28 11.3062 27.2962 9.33284 25.9776C7.35945 24.6591 5.82138 22.7849 4.91313 20.5922C4.00488 18.3995 3.76724 15.9867 4.23026 13.6589C4.69328 11.3312 5.83617 9.19296 7.5144 7.51473C9.19263 5.8365 11.3308 4.69361 13.6586 4.23059C15.9864 3.76757 18.3992 4.00521 20.5919 4.91346C22.7846 5.82171 24.6587 7.35978 25.9773 9.33317C27.2959 11.3066 27.9997 13.6266 27.9997 16C27.9962 19.1815 26.7307 22.2317 24.4811 24.4814C22.2314 26.7311 19.1812 27.9965 15.9997 28Z\" fill=\"#464255\"/>
                            <path d=\"M21.7648 11.684L14.7061 18.1546L11.6088 15.0573C11.4858 14.93 11.3387 14.8284 11.176 14.7585C11.0133 14.6886 10.8384 14.6518 10.6613 14.6503C10.4843 14.6488 10.3087 14.6825 10.1449 14.7495C9.98099 14.8166 9.83212 14.9156 9.70693 15.0408C9.58174 15.166 9.48274 15.3148 9.41569 15.4787C9.34865 15.6426 9.31492 15.8181 9.31646 15.9952C9.318 16.1722 9.35478 16.3472 9.42466 16.5098C9.49453 16.6725 9.59611 16.8196 9.72346 16.9426L13.7235 20.9426C13.9664 21.1857 14.2939 21.3255 14.6374 21.3329C14.981 21.3404 15.3142 21.2149 15.5675 20.9826L23.5675 13.6493C23.8281 13.4103 23.9831 13.0775 23.9983 12.7241C24.0136 12.3708 23.8878 12.0259 23.6488 11.7653C23.4097 11.5047 23.077 11.3497 22.7236 11.3344C22.3703 11.3192 22.0254 11.4449 21.7648 11.684Z\" fill=\"#464255\"/>
                        </svg>
                    </div>
                </div>
                <div class=\"geex-content__summary__count__single warning-bg\">
                    <div class=\"geex-content__summary__count__single__content\">
                        <h4 class=\"geex-content__summary__count__single__title\">168</h4>
                        <p class=\"geex-content__summary__count__single__subtitle\">Unpaid Invoices</p>
                    </div>
                    <div class=\"geex-content__summary__count__single__icon\">
                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"32\" height=\"32\" viewBox=\"0 0 32 32\" fill=\"none\">
                            <path d=\"M15.9997 1.33322C13.0989 1.33322 10.2632 2.1934 7.85132 3.805C5.4394 5.41659 3.55953 7.70721 2.44945 10.3872C1.33936 13.0672 1.04891 16.0162 1.61483 18.8612C2.18075 21.7063 3.57761 24.3196 5.62878 26.3708C7.67995 28.422 10.2933 29.8188 13.1384 30.3847C15.9834 30.9506 18.9324 30.6602 21.6124 29.5501C24.2924 28.44 26.583 26.5602 28.1946 24.1482C29.8062 21.7363 30.6664 18.9007 30.6664 15.9999C30.6618 12.1115 29.1151 8.38359 26.3655 5.63405C23.616 2.88451 19.8881 1.3378 15.9997 1.33322ZM15.9997 27.9999C13.6263 27.9999 11.3062 27.2961 9.33284 25.9775C7.35945 24.6589 5.82138 22.7848 4.91313 20.5921C4.00488 18.3994 3.76724 15.9866 4.23026 13.6588C4.69328 11.331 5.83617 9.19283 7.5144 7.5146C9.19263 5.83637 11.3308 4.69348 13.6586 4.23046C15.9864 3.76744 18.3992 4.00508 20.5919 4.91333C22.7846 5.82158 24.6587 7.35965 25.9773 9.33304C27.2959 11.3064 27.9997 13.6265 27.9997 15.9999C27.9958 19.1813 26.7303 22.2313 24.4807 24.4809C22.2311 26.7305 19.1811 27.996 15.9997 27.9999Z\" fill=\"#464255\"/>
                            <path d=\"M16.0003 8.00001C15.6467 8.00001 15.3076 8.14048 15.0575 8.39053C14.8075 8.64058 14.667 8.97972 14.667 9.33334V18.6667C14.667 19.0203 14.8075 19.3594 15.0575 19.6095C15.3076 19.8595 15.6467 20 16.0003 20C16.354 20 16.6931 19.8595 16.9431 19.6095C17.1932 19.3594 17.3337 19.0203 17.3337 18.6667V9.33334C17.3337 8.97972 17.1932 8.64058 16.9431 8.39053C16.6931 8.14048 16.354 8.00001 16.0003 8.00001Z\" fill=\"#464255\"/>
                            <path d=\"M16.0003 23.9999C16.7367 23.9999 17.3337 23.403 17.3337 22.6666C17.3337 21.9302 16.7367 21.3332 16.0003 21.3332C15.2639 21.3332 14.667 21.9302 14.667 22.6666C14.667 23.403 15.2639 23.9999 16.0003 23.9999Z\" fill=\"#464255\"/>
                        </svg>
                    </div>
                </div>
            </div>
            <div class=\"geex-content__summary__balance\">
                <img src=\"assets/img/balance-bg.svg\" class=\"geex-content__summary__balance__img\" alt=\"Invoice\" />
                <div class=\"geex-content__summary__balance__content\">
                    <span class=\"geex-content__summary__balance__subtitle\">Balance</span>
                    <h2 class=\"geex-content__summary__balance__title\">\$ 1,500.00</h2>
                    <span class=\"geex-content__summary__balance__time\">Tuesday, February 2nd 2024, 9:24 AM</span>
                    <span class=\"geex-content__summary__balance__chip\">Main Wallet</span>
                    <button class=\"geex-content__summary__balance__more geex-content__toggle__btn\">
                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                            <path d=\"M14.0003 8.16667C15.289 8.16667 16.3337 7.122 16.3337 5.83333C16.3337 4.54467 15.289 3.5 14.0003 3.5C12.7117 3.5 11.667 4.54467 11.667 5.83333C11.667 7.122 12.7117 8.16667 14.0003 8.16667Z\" fill=\"white\"/>
                            <path d=\"M14.0003 16.3334C15.289 16.3334 16.3337 15.2887 16.3337 14C16.3337 12.7114 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7114 11.667 14C11.667 15.2887 12.7117 16.3334 14.0003 16.3334Z\" fill=\"white\"/>
                            <path d=\"M14.0003 24.4999C15.289 24.4999 16.3337 23.4553 16.3337 22.1666C16.3337 20.8779 15.289 19.8333 14.0003 19.8333C12.7117 19.8333 11.667 20.8779 11.667 22.1666C11.667 23.4553 12.7117 24.4999 14.0003 24.4999Z\" fill=\"white\"/>
                        </svg>
                    </button>
                    <ul class=\"geex-content__summary__balance__more__content geex-content__toggle__content \">
                        <li><a href=\"#\">View Statement</a></li>
                        <li><a href=\"#\">Withdraw</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class=\"geex-content__invoice\">
            <div class=\"geex-content__invoice__list\">
                <div class=\"geex-content__todo__header\">
                    <div class=\"geex-content__todo__header__title\">
                        <h4>Invoice List</h4>
                        <p>Eum fuga consequuntur ut et.</p>
                    </div>
                    <ul class=\"nav nav-tabs geex-todo-tab geex-content__todo__header__filter\" id=\"geex-invoice-tab\" role=\"tablist\">
                        <li class=\"geex-content__todo__header__filter__sortby\">
                            <select>
                                <option value=\"newest\">Newest</option>
                                <option value=\"oldest\">Oldest</option>
                                <option value=\"name\">Name</option>
                            </select>
                            <i class=\"uil-angle-down\"></i>
                        </li>
                        <li class=\"nav-item\" role=\"presentation\">
                            <a href=\"#\" id=\"invoice_list_tab\" class=\"active\" data-bs-toggle=\"tab\" data-bs-target=\"#invoice_list_content\" type=\"button\" role=\"tab\" aria-controls=\"invoice_list_content\" aria-selected=\"false\">
                                <i class=\"uil-bars\"></i>
                            </a>
                        </li>
                        <li class=\"nav-item\" role=\"presentation\">
                            <a href=\"#\" id=\"invoice_grid_tab\" data-bs-toggle=\"tab\" data-bs-target=\"#invoice_grid_content\" type=\"button\" role=\"tab\" aria-controls=\"invoice_grid_contant\" aria-selected=\"false\">
                                <i class=\"uil-apps\"></i>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class=\"tab-content geex-transaction-content\">
                    <div class=\"tab-pane fade show active\" id=\"invoice_list_content\" role=\"tabpanel\" aria-labelledby=\"invoice_list_tab\">
                        <div class=\"geex-content__todo__list\">
                            <div class=\"geex-content__todo__list__single geex-content__todo__list__single--header\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-1\" id=\"invoice-1\" />
                                    <label for=\"invoice-1\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">Invoice Number</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Receipent</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Date</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Amount</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Status</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Action</span>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-11\" id=\"invoice-11\" />
                                    <label for=\"invoice-11\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231255</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user1.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Samuel</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 1/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$549.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-12\" id=\"invoice-12\" />
                                    <label for=\"invoice-12\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231256</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user2.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Bella</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 2/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$876.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-13\" id=\"invoice-13\" />
                                    <label for=\"invoice-13\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231257</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user3.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Dejon</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 3/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$146.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-14\" id=\"invoice-14\" />
                                    <label for=\"invoice-14\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231262</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user4.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">William</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 5/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$346.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-15\" id=\"invoice-15\" />
                                    <label for=\"invoice-15\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231235</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user5.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Lurile</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 1/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$749.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class=\"tab-pane fade\" id=\"invoice_grid_content\" role=\"tabpanel\" aria-labelledby=\"invoice_grid_tab\">
                        <div class=\"geex-content__todo__list geex-content__todo__list--grid\">
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-21\" id=\"invoice-21\" />
                                    <label for=\"invoice-21\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231255</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user1.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Samuel</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 1/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$549.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-22\" id=\"invoice-22\" />
                                    <label for=\"invoice-22\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231256</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user2.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Bella</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 2/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$876.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-23\" id=\"invoice-23\" />
                                    <label for=\"invoice-23\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231257</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user3.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Dejon</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 3/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$146.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-24\" id=\"invoice-24\" />
                                    <label for=\"invoice-24\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231262</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user4.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">William</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 5/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$346.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-25\" id=\"invoice-30\" />
                                    <label for=\"invoice-30\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231235</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user5.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Lurile</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 1/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$749.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class=\"geex-content__invoice__chat\">
                <button class=\"geex-content__invoice__chat__toggler\">
                    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                        <path d=\"M3 13H18.59L13.29 18.29C13.1963 18.383 13.1219 18.4936 13.0711 18.6154C13.0203 18.7373 12.9942 18.868 12.9942 19C12.9942 19.132 13.0203 19.2627 13.0711 19.3846C13.1219 19.5064 13.1963 19.617 13.29 19.71C13.383 19.8037 13.4936 19.8781 13.6154 19.9289C13.7373 19.9797 13.868 20.0058 14 20.0058C14.132 20.0058 14.2627 19.9797 14.3846 19.9289C14.5064 19.8781 14.617 19.8037 14.71 19.71L21.71 12.71C21.8037 12.617 21.8781 12.5064 21.9289 12.3846C21.9797 12.2627 22.0058 12.132 22.0058 12C22.0058 11.868 21.9797 11.7373 21.9289 11.6154C21.8781 11.4936 21.8037 11.383 21.71 11.29L14.71 4.29C14.6168 4.19676 14.5061 4.1228 14.3843 4.07234C14.2624 4.02188 14.1319 3.99591 14 3.99591C13.7337 3.99591 13.4783 4.1017 13.29 4.29C13.1968 4.38324 13.1228 4.49393 13.0723 4.61575C13.0219 4.73758 12.9959 4.86814 12.9959 5C12.9959 5.2663 13.1017 5.5217 13.29 5.71L18.59 11H3C2.73478 11 2.48043 11.1054 2.29289 11.2929C2.10536 11.4804 2 11.7348 2 12C2 12.2652 2.10536 12.5196 2.29289 12.7071C2.48043 12.8946 2.73478 13 3 13Z\" fill=\"#464255\"/>
                    </svg>
                </button>

                <div class=\"geex-content__invoice__chat__wrapper\">
                    <div class=\"geex-content__todo__header\">
                        <div class=\"geex-content__todo__header__title\">
                            <h4>Send Invoices</h4>
                            <p>Eum fuga consequuntur ut et.</p>
                        </div>
                    </div>

                    <div class=\"geex-content__invoice__chat__content\">
                        <div class=\"geex-content__invoice__chat__content__single\">
                            <span class=\"geex-content__invoice__chat__subtitle\">
                                Choose Receipent
                            </span>
                            <div class=\"geex-content__invoice__chat__author\">
                                <a href=\"#\" class=\"geex-content__invoice__chat__author__single\">
                                    <img src=\"assets/img/avatar/user1.svg\" alt=\"User\" />
                                    <span class=\"geex-content__invoice__chat__author__single__name\">Dave</span>
                                </a>
                                <a href=\"#\" class=\"geex-content__invoice__chat__author__single\">
                                    <img src=\"assets/img/avatar/user2.svg\" alt=\"User\" />
                                    <span class=\"geex-content__invoice__chat__author__single__name\">Ismael</span>
                                </a>
                                <a href=\"#\" class=\"geex-content__invoice__chat__author__single\">
                                    <img src=\"assets/img/avatar/user3.svg\" alt=\"User\" />
                                    <span class=\"geex-content__invoice__chat__author__single__name\">Dinda</span>
                                </a>
                            </div>
                        </div>
                        <div class=\"geex-content__invoice__chat__content__single\">
                            <span class=\"geex-content__invoice__chat__subtitle\">
                                Choose Service
                            </span>
                            <div class=\"geex-content__invoice__chat__service\">
                                <select id=\"selectService\" class=\"invoice_service\">
                                    <option value=\"service\">Maintenance Service</option>
                                    <option value=\"service1\">Service One</option>
                                    <option value=\"service2\">Service Two</option>
                                    <option value=\"service3\">Service Three</option>
                                </select>
                                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                    <path d=\"M13.9873 19.217C13.7177 19.2146 13.4596 19.1076 13.2674 18.9186L3.08562 8.73681C2.90015 8.54478 2.79752 8.28759 2.79984 8.02062C2.80216 7.75366 2.90924 7.49829 3.09802 7.30951C3.2868 7.12073 3.54217 7.01365 3.80914 7.01133C4.0761 7.00901 4.3333 7.11164 4.52533 7.29711L13.9873 16.7591L23.4493 7.29711C23.5432 7.19986 23.6555 7.12229 23.7798 7.06893C23.904 7.01557 24.0376 6.98748 24.1728 6.98631C24.308 6.98513 24.442 7.01089 24.5672 7.06209C24.6923 7.11328 24.806 7.18889 24.9016 7.28449C24.9972 7.38009 25.0728 7.49377 25.124 7.6189C25.1752 7.74403 25.2009 7.8781 25.1998 8.0133C25.1986 8.14849 25.1705 8.2821 25.1171 8.40632C25.0638 8.53054 24.9862 8.64289 24.889 8.73681L14.7071 18.9186C14.515 19.1076 14.2568 19.2146 13.9873 19.217Z\" fill=\"#AB54DB\"/>
                                </svg>
                            </div>
                        </div>
                        <div class=\"geex-content__invoice__chat__content__single\">
                            <span class=\"geex-content__invoice__chat__subtitle\">
                                Label
                            </span>
                            <div class=\"geex-content__invoice__chat__amount\">
                                <label for=\"invoice_amount\">
                                    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                        <path d=\"M14 10.5H16.3333C16.6428 10.5 16.9395 10.3771 17.1583 10.1583C17.3771 9.9395 17.5 9.64275 17.5 9.33333C17.5 9.02391 17.3771 8.72717 17.1583 8.50838C16.9395 8.28958 16.6428 8.16667 16.3333 8.16667H15.1667C15.1667 7.85725 15.0437 7.5605 14.825 7.34171C14.6062 7.12292 14.3094 7 14 7C13.6906 7 13.3938 7.12292 13.175 7.34171C12.9562 7.5605 12.8333 7.85725 12.8333 8.16667V8.37667C12.0617 8.65664 11.4131 9.1989 11.0008 9.90865C10.5885 10.6184 10.4387 11.4505 10.5777 12.2595C10.7167 13.0684 11.1356 13.8028 11.7612 14.3342C12.3868 14.8657 13.1792 15.1603 14 15.1667C14.3094 15.1667 14.6062 15.2896 14.825 15.5084C15.0437 15.7272 15.1667 16.0239 15.1667 16.3333C15.1667 16.6428 15.0437 16.9395 14.825 17.1583C14.6062 17.3771 14.3094 17.5 14 17.5H11.6667C11.3572 17.5 11.0605 17.6229 10.8417 17.8417C10.6229 18.0605 10.5 18.3572 10.5 18.6667C10.5 18.9761 10.6229 19.2728 10.8417 19.4916C11.0605 19.7104 11.3572 19.8333 11.6667 19.8333H12.8333C12.8333 20.1428 12.9562 20.4395 13.175 20.6583C13.3938 20.8771 13.6906 21 14 21C14.3094 21 14.6062 20.8771 14.825 20.6583C15.0437 20.4395 15.1667 20.1428 15.1667 19.8333V19.6233C15.9383 19.3434 16.5869 18.8011 16.9992 18.0913C17.4115 17.3816 17.5613 16.5495 17.4223 15.7405C17.2833 14.9316 16.8644 14.1972 16.2388 13.6658C15.6132 13.1343 14.8208 12.8397 14 12.8333C13.6906 12.8333 13.3938 12.7104 13.175 12.4916C12.9562 12.2728 12.8333 11.9761 12.8333 11.6667C12.8333 11.3572 12.9562 11.0605 13.175 10.8417C13.3938 10.6229 13.6906 10.5 14 10.5Z\" fill=\"#A3A3A3\"/>
                                        <path d=\"M14.0007 2.33337C11.6932 2.33337 9.43758 3.01761 7.519 4.29956C5.60043 5.58151 4.10508 7.4036 3.22206 9.5354C2.33904 11.6672 2.108 14.013 2.55816 16.2761C3.00832 18.5392 4.11946 20.618 5.75108 22.2496C7.38269 23.8812 9.46149 24.9924 11.7246 25.4425C13.9877 25.8927 16.3335 25.6617 18.4653 24.7786C20.5971 23.8956 22.4192 22.4003 23.7011 20.4817C24.9831 18.5631 25.6673 16.3075 25.6673 14C25.6673 12.468 25.3656 10.9509 24.7793 9.5354C24.1929 8.11994 23.3336 6.83381 22.2502 5.75046C21.1669 4.66711 19.8808 3.80775 18.4653 3.22145C17.0498 2.63514 15.5327 2.33337 14.0007 2.33337ZM14.0007 23.3334C12.1547 23.3334 10.3502 22.786 8.81533 21.7604C7.28047 20.7349 6.0842 19.2772 5.37778 17.5718C4.67136 15.8663 4.48653 13.9897 4.84666 12.1792C5.20679 10.3687 6.0957 8.70567 7.40099 7.40038C8.70628 6.09509 10.3693 5.20617 12.1798 4.84605C13.9903 4.48592 15.8669 4.67075 17.5724 5.37717C19.2778 6.08358 20.7355 7.27986 21.761 8.81472C22.7866 10.3496 23.334 12.1541 23.334 14C23.334 16.4754 22.3507 18.8494 20.6003 20.5997C18.85 22.35 16.476 23.3334 14.0007 23.3334Z\" fill=\"#A3A3A3\"/>
                                    </svg>
                                </label>
                                <input type=\"number\" id=\"invoice_amount\" name=\"invoice_amount\" placeholder=\"Insert amount\" />
                            </div>
                        </div>
                        <button class=\"geex-content__invoice__chat__btn geex-btn geex-btn--primary\">
                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                <path d=\"M26.7077 1.29306C26.572 1.15701 26.3999 1.06296 26.2121 1.02217C26.0243 0.981382 25.8287 0.995577 25.6487 1.06306L2.49472 9.74606C2.0738 9.90231 1.70781 10.1783 1.4419 10.5401C1.17598 10.9019 1.02177 11.3336 0.99827 11.7819C0.974772 12.2303 1.08302 12.6757 1.30966 13.0633C1.53631 13.4509 1.87144 13.7637 2.27372 13.9631L10.1157 17.8841L14.0367 25.7261C14.2244 26.1102 14.5168 26.4336 14.8802 26.659C15.2435 26.8844 15.6631 27.0026 16.0907 27.0001H16.2177C16.6665 26.9803 17.0994 26.8282 17.4619 26.5628C17.8244 26.2975 18.1002 25.9309 18.2547 25.5091L26.9377 2.35106C27.005 2.17124 27.0191 1.97585 26.9783 1.78824C26.9375 1.60063 26.8436 1.42872 26.7077 1.29306V1.29306ZM16.3817 24.8001C16.3634 24.8573 16.3276 24.9074 16.2793 24.9432C16.2311 24.9791 16.1728 24.999 16.1127 25.0001C16.0536 25.0035 15.9949 24.9894 15.9438 24.9595C15.8927 24.9296 15.8517 24.8852 15.8257 24.8321L12.0777 17.3321L16.7077 12.7021C16.8899 12.5135 16.9907 12.2609 16.9884 11.9987C16.9861 11.7365 16.8809 11.4856 16.6955 11.3002C16.5101 11.1148 16.2593 11.0097 15.9971 11.0074C15.7349 11.0051 15.4823 11.1059 15.2937 11.2881L10.6637 15.9181L3.16872 12.1751C3.11439 12.1499 3.06884 12.109 3.03794 12.0577C3.00703 12.0064 2.99218 11.9471 2.9953 11.8873C2.99842 11.8275 3.01937 11.77 3.05544 11.7222C3.09151 11.6744 3.14107 11.6385 3.19772 11.6191L24.2917 3.70906L16.3817 24.8001Z\" fill=\"white\"/>
                            </svg>
                            Send Invoices
                        </button>
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
        return "home/index4.html.twig";
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

{% block title %}Invoicing - Geex Dashboard{% endblock %}

{% block mainHeader %}Invoicing{% endblock %}

{% block content %}Welcome to Geex Modern Admin Dashboard{% endblock %}

{% block body %}

<div class=\"geex-content__wrapper\">
    <div class=\"geex-content__section-wrapper\">
        <div class=\"geex-content__summary\">
            <div class=\"geex-content__summary__count\">
                <div class=\"geex-content__summary__count__single primay-bg\">
                    <div class=\"geex-content__summary__count__single__content\">
                        <h4 class=\"geex-content__summary__count__single__title\">982</h4>
                        <p class=\"geex-content__summary__count__single__subtitle\">Invoice Sent</p>
                    </div>
                    <div class=\"geex-content__summary__count__single__icon\">
                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"32\" height=\"32\" viewBox=\"0 0 32 32\" fill=\"none\">
                            <path d=\"M26.9908 5.10791C26.7542 4.84524 26.4229 4.68728 26.0699 4.66878C25.7168 4.65027 25.3709 4.77274 25.1081 5.00925L12.7148 16.1626L6.94277 10.3906C6.81978 10.2632 6.67265 10.1617 6.50998 10.0918C6.34731 10.0219 6.17235 9.98512 5.99531 9.98358C5.81827 9.98204 5.6427 10.0158 5.47884 10.0828C5.31497 10.1499 5.16611 10.2489 5.04091 10.3741C4.91572 10.4992 4.81672 10.6481 4.74968 10.812C4.68264 10.9758 4.6489 11.1514 4.65044 11.3285C4.65198 11.5055 4.68876 11.6804 4.75864 11.8431C4.82852 12.0058 4.93009 12.1529 5.05744 12.2759L11.7241 18.9426C11.9656 19.184 12.2905 19.3235 12.6319 19.3325C12.9732 19.3414 13.305 19.219 13.5588 18.9906L26.8921 6.99058C27.1548 6.75397 27.3127 6.42272 27.3312 6.06968C27.3498 5.71663 27.2273 5.37069 26.9908 5.10791Z\" fill=\"#464255\"/>
                            <path d=\"M25.1085 13.0093L12.7152 24.1626L6.94321 18.3906C6.69174 18.1478 6.35494 18.0134 6.00534 18.0164C5.65575 18.0195 5.32133 18.1597 5.07412 18.4069C4.82691 18.6541 4.68668 18.9885 4.68364 19.3381C4.68061 19.6877 4.815 20.0245 5.05788 20.276L11.7245 26.9426C11.966 27.1841 12.291 27.3236 12.6323 27.3325C12.9737 27.3415 13.3054 27.2191 13.5592 26.9906L26.8925 14.9906C27.1473 14.752 27.2983 14.423 27.3131 14.0742C27.3279 13.7255 27.2054 13.3848 26.9718 13.1254C26.7383 12.866 26.4123 12.7086 26.0639 12.6868C25.7155 12.6651 25.3725 12.7809 25.1085 13.0093Z\" fill=\"#464255\"/>
                          </svg>
                    </div>
                </div>
                <div class=\"geex-content__summary__count__single danger-bg\">
                    <div class=\"geex-content__summary__count__single__content\">
                        <h4 class=\"geex-content__summary__count__single__title\">45</h4>
                        <p class=\"geex-content__summary__count__single__subtitle\">Pending Invoice</p>
                    </div>
                    <div class=\"geex-content__summary__count__single__icon\">
                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"32\" height=\"32\" viewBox=\"0 0 32 32\" fill=\"none\">
                            <path d=\"M15.9997 1.33321C13.0989 1.33321 10.2632 2.19339 7.85132 3.80498C5.4394 5.41658 3.55953 7.7072 2.44945 10.3872C1.33936 13.0672 1.04891 16.0161 1.61483 18.8612C2.18075 21.7063 3.57761 24.3196 5.62878 26.3708C7.67995 28.4219 10.2933 29.8188 13.1384 30.3847C15.9834 30.9506 18.9324 30.6602 21.6124 29.5501C24.2924 28.44 26.583 26.5602 28.1946 24.1482C29.8062 21.7363 30.6664 18.9007 30.6664 15.9999C30.6618 12.1114 29.1151 8.38358 26.3655 5.63404C23.616 2.8845 19.8881 1.33779 15.9997 1.33321ZM15.9997 27.9999C13.6263 27.9999 11.3062 27.2961 9.33284 25.9775C7.35945 24.6589 5.82138 22.7848 4.91313 20.5921C4.00488 18.3994 3.76724 15.9866 4.23026 13.6588C4.69328 11.331 5.83617 9.19282 7.5144 7.51459C9.19263 5.83636 11.3308 4.69347 13.6586 4.23045C15.9864 3.76743 18.3992 4.00507 20.5919 4.91332C22.7846 5.82157 24.6587 7.35964 25.9773 9.33303C27.2959 11.3064 27.9997 13.6265 27.9997 15.9999C27.9958 19.1813 26.7303 22.2313 24.4807 24.4809C22.2311 26.7305 19.1811 27.996 15.9997 27.9999Z\" fill=\"#464255\"/>
                            <path d=\"M18.9433 7.55344C18.1839 7.05351 17.3108 6.75286 16.4046 6.67923C15.4984 6.60559 14.5882 6.76134 13.758 7.13211C12.8218 7.54836 12.0291 8.23143 11.4792 9.09587C10.9292 9.96031 10.6463 10.9677 10.666 11.9921V12.0001C10.6671 12.3537 10.8086 12.6925 11.0594 12.9417C11.3101 13.191 11.6497 13.3305 12.0033 13.3294C12.357 13.3284 12.6957 13.1869 12.945 12.9361C13.1943 12.6853 13.3337 12.3457 13.3327 11.9921C13.3191 11.4931 13.4503 11.0009 13.7106 10.5749C13.9709 10.149 14.3491 9.80763 14.7993 9.59211C15.224 9.3921 15.6928 9.30424 16.161 9.33692C16.6292 9.3696 17.0813 9.52172 17.474 9.77878C17.8246 10.0106 18.1154 10.3221 18.3227 10.6877C18.53 11.0533 18.6479 11.4627 18.6669 11.8826C18.6859 12.3025 18.6054 12.7209 18.4319 13.1037C18.2584 13.4865 17.9969 13.8229 17.6687 14.0854C16.756 14.7825 16.0122 15.6761 15.4923 16.7001C14.9725 17.7241 14.6901 18.852 14.666 20.0001C14.6666 20.1752 14.7017 20.3485 14.7693 20.51C14.8369 20.6715 14.9356 20.8182 15.0598 20.9416C15.1841 21.0649 15.3314 21.1626 15.4934 21.2291C15.6554 21.2955 15.8289 21.3294 16.004 21.3288C16.1791 21.3282 16.3524 21.2931 16.5139 21.2255C16.6754 21.1579 16.8221 21.0592 16.9454 20.935C17.0688 20.8107 17.1665 20.6634 17.233 20.5014C17.2994 20.3394 17.3333 20.1659 17.3327 19.9908C17.3582 19.2435 17.5512 18.5115 17.8974 17.8488C18.2435 17.186 18.734 16.6094 19.3327 16.1614C19.9879 15.6361 20.5098 14.9634 20.8559 14.1982C21.202 13.4329 21.3624 12.5968 21.3242 11.7578C21.286 10.9188 21.0502 10.1008 20.636 9.37015C20.2218 8.63954 19.6409 8.01708 18.9407 7.55344H18.9433Z\" fill=\"#464255\"/>
                            <path d=\"M16.0003 25.3335C16.7367 25.3335 17.3337 24.7365 17.3337 24.0001C17.3337 23.2637 16.7367 22.6668 16.0003 22.6668C15.2639 22.6668 14.667 23.2637 14.667 24.0001C14.667 24.7365 15.2639 25.3335 16.0003 25.3335Z\" fill=\"#464255\"/>
                        </svg>
                    </div>
                </div>
                <div class=\"geex-content__summary__count__single success-bg\">
                    <div class=\"geex-content__summary__count__single__content\">
                        <h4 class=\"geex-content__summary__count__single__title\">73</h4>
                        <p class=\"geex-content__summary__count__single__subtitle\">Paid Invoice</p>
                    </div>
                    <div class=\"geex-content__summary__count__single__icon\">
                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"32\" height=\"32\" viewBox=\"0 0 32 32\" fill=\"none\">
                            <path d=\"M15.9997 1.33335C13.0989 1.33335 10.2632 2.19353 7.85132 3.80513C5.4394 5.41672 3.55953 7.70734 2.44945 10.3873C1.33936 13.0673 1.04891 16.0163 1.61483 18.8613C2.18075 21.7064 3.57761 24.3197 5.62878 26.3709C7.67995 28.4221 10.2933 29.8189 13.1384 30.3849C15.9834 30.9508 18.9324 30.6603 21.6124 29.5502C24.2924 28.4402 26.583 26.5603 28.1946 24.1484C29.8062 21.7365 30.6664 18.9008 30.6664 16C30.6618 12.1116 29.1151 8.38372 26.3655 5.63418C23.616 2.88464 19.8881 1.33793 15.9997 1.33335ZM15.9997 28C13.6263 28 11.3062 27.2962 9.33284 25.9776C7.35945 24.6591 5.82138 22.7849 4.91313 20.5922C4.00488 18.3995 3.76724 15.9867 4.23026 13.6589C4.69328 11.3312 5.83617 9.19296 7.5144 7.51473C9.19263 5.8365 11.3308 4.69361 13.6586 4.23059C15.9864 3.76757 18.3992 4.00521 20.5919 4.91346C22.7846 5.82171 24.6587 7.35978 25.9773 9.33317C27.2959 11.3066 27.9997 13.6266 27.9997 16C27.9962 19.1815 26.7307 22.2317 24.4811 24.4814C22.2314 26.7311 19.1812 27.9965 15.9997 28Z\" fill=\"#464255\"/>
                            <path d=\"M21.7648 11.684L14.7061 18.1546L11.6088 15.0573C11.4858 14.93 11.3387 14.8284 11.176 14.7585C11.0133 14.6886 10.8384 14.6518 10.6613 14.6503C10.4843 14.6488 10.3087 14.6825 10.1449 14.7495C9.98099 14.8166 9.83212 14.9156 9.70693 15.0408C9.58174 15.166 9.48274 15.3148 9.41569 15.4787C9.34865 15.6426 9.31492 15.8181 9.31646 15.9952C9.318 16.1722 9.35478 16.3472 9.42466 16.5098C9.49453 16.6725 9.59611 16.8196 9.72346 16.9426L13.7235 20.9426C13.9664 21.1857 14.2939 21.3255 14.6374 21.3329C14.981 21.3404 15.3142 21.2149 15.5675 20.9826L23.5675 13.6493C23.8281 13.4103 23.9831 13.0775 23.9983 12.7241C24.0136 12.3708 23.8878 12.0259 23.6488 11.7653C23.4097 11.5047 23.077 11.3497 22.7236 11.3344C22.3703 11.3192 22.0254 11.4449 21.7648 11.684Z\" fill=\"#464255\"/>
                        </svg>
                    </div>
                </div>
                <div class=\"geex-content__summary__count__single warning-bg\">
                    <div class=\"geex-content__summary__count__single__content\">
                        <h4 class=\"geex-content__summary__count__single__title\">168</h4>
                        <p class=\"geex-content__summary__count__single__subtitle\">Unpaid Invoices</p>
                    </div>
                    <div class=\"geex-content__summary__count__single__icon\">
                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"32\" height=\"32\" viewBox=\"0 0 32 32\" fill=\"none\">
                            <path d=\"M15.9997 1.33322C13.0989 1.33322 10.2632 2.1934 7.85132 3.805C5.4394 5.41659 3.55953 7.70721 2.44945 10.3872C1.33936 13.0672 1.04891 16.0162 1.61483 18.8612C2.18075 21.7063 3.57761 24.3196 5.62878 26.3708C7.67995 28.422 10.2933 29.8188 13.1384 30.3847C15.9834 30.9506 18.9324 30.6602 21.6124 29.5501C24.2924 28.44 26.583 26.5602 28.1946 24.1482C29.8062 21.7363 30.6664 18.9007 30.6664 15.9999C30.6618 12.1115 29.1151 8.38359 26.3655 5.63405C23.616 2.88451 19.8881 1.3378 15.9997 1.33322ZM15.9997 27.9999C13.6263 27.9999 11.3062 27.2961 9.33284 25.9775C7.35945 24.6589 5.82138 22.7848 4.91313 20.5921C4.00488 18.3994 3.76724 15.9866 4.23026 13.6588C4.69328 11.331 5.83617 9.19283 7.5144 7.5146C9.19263 5.83637 11.3308 4.69348 13.6586 4.23046C15.9864 3.76744 18.3992 4.00508 20.5919 4.91333C22.7846 5.82158 24.6587 7.35965 25.9773 9.33304C27.2959 11.3064 27.9997 13.6265 27.9997 15.9999C27.9958 19.1813 26.7303 22.2313 24.4807 24.4809C22.2311 26.7305 19.1811 27.996 15.9997 27.9999Z\" fill=\"#464255\"/>
                            <path d=\"M16.0003 8.00001C15.6467 8.00001 15.3076 8.14048 15.0575 8.39053C14.8075 8.64058 14.667 8.97972 14.667 9.33334V18.6667C14.667 19.0203 14.8075 19.3594 15.0575 19.6095C15.3076 19.8595 15.6467 20 16.0003 20C16.354 20 16.6931 19.8595 16.9431 19.6095C17.1932 19.3594 17.3337 19.0203 17.3337 18.6667V9.33334C17.3337 8.97972 17.1932 8.64058 16.9431 8.39053C16.6931 8.14048 16.354 8.00001 16.0003 8.00001Z\" fill=\"#464255\"/>
                            <path d=\"M16.0003 23.9999C16.7367 23.9999 17.3337 23.403 17.3337 22.6666C17.3337 21.9302 16.7367 21.3332 16.0003 21.3332C15.2639 21.3332 14.667 21.9302 14.667 22.6666C14.667 23.403 15.2639 23.9999 16.0003 23.9999Z\" fill=\"#464255\"/>
                        </svg>
                    </div>
                </div>
            </div>
            <div class=\"geex-content__summary__balance\">
                <img src=\"assets/img/balance-bg.svg\" class=\"geex-content__summary__balance__img\" alt=\"Invoice\" />
                <div class=\"geex-content__summary__balance__content\">
                    <span class=\"geex-content__summary__balance__subtitle\">Balance</span>
                    <h2 class=\"geex-content__summary__balance__title\">\$ 1,500.00</h2>
                    <span class=\"geex-content__summary__balance__time\">Tuesday, February 2nd 2024, 9:24 AM</span>
                    <span class=\"geex-content__summary__balance__chip\">Main Wallet</span>
                    <button class=\"geex-content__summary__balance__more geex-content__toggle__btn\">
                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                            <path d=\"M14.0003 8.16667C15.289 8.16667 16.3337 7.122 16.3337 5.83333C16.3337 4.54467 15.289 3.5 14.0003 3.5C12.7117 3.5 11.667 4.54467 11.667 5.83333C11.667 7.122 12.7117 8.16667 14.0003 8.16667Z\" fill=\"white\"/>
                            <path d=\"M14.0003 16.3334C15.289 16.3334 16.3337 15.2887 16.3337 14C16.3337 12.7114 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7114 11.667 14C11.667 15.2887 12.7117 16.3334 14.0003 16.3334Z\" fill=\"white\"/>
                            <path d=\"M14.0003 24.4999C15.289 24.4999 16.3337 23.4553 16.3337 22.1666C16.3337 20.8779 15.289 19.8333 14.0003 19.8333C12.7117 19.8333 11.667 20.8779 11.667 22.1666C11.667 23.4553 12.7117 24.4999 14.0003 24.4999Z\" fill=\"white\"/>
                        </svg>
                    </button>
                    <ul class=\"geex-content__summary__balance__more__content geex-content__toggle__content \">
                        <li><a href=\"#\">View Statement</a></li>
                        <li><a href=\"#\">Withdraw</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class=\"geex-content__invoice\">
            <div class=\"geex-content__invoice__list\">
                <div class=\"geex-content__todo__header\">
                    <div class=\"geex-content__todo__header__title\">
                        <h4>Invoice List</h4>
                        <p>Eum fuga consequuntur ut et.</p>
                    </div>
                    <ul class=\"nav nav-tabs geex-todo-tab geex-content__todo__header__filter\" id=\"geex-invoice-tab\" role=\"tablist\">
                        <li class=\"geex-content__todo__header__filter__sortby\">
                            <select>
                                <option value=\"newest\">Newest</option>
                                <option value=\"oldest\">Oldest</option>
                                <option value=\"name\">Name</option>
                            </select>
                            <i class=\"uil-angle-down\"></i>
                        </li>
                        <li class=\"nav-item\" role=\"presentation\">
                            <a href=\"#\" id=\"invoice_list_tab\" class=\"active\" data-bs-toggle=\"tab\" data-bs-target=\"#invoice_list_content\" type=\"button\" role=\"tab\" aria-controls=\"invoice_list_content\" aria-selected=\"false\">
                                <i class=\"uil-bars\"></i>
                            </a>
                        </li>
                        <li class=\"nav-item\" role=\"presentation\">
                            <a href=\"#\" id=\"invoice_grid_tab\" data-bs-toggle=\"tab\" data-bs-target=\"#invoice_grid_content\" type=\"button\" role=\"tab\" aria-controls=\"invoice_grid_contant\" aria-selected=\"false\">
                                <i class=\"uil-apps\"></i>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class=\"tab-content geex-transaction-content\">
                    <div class=\"tab-pane fade show active\" id=\"invoice_list_content\" role=\"tabpanel\" aria-labelledby=\"invoice_list_tab\">
                        <div class=\"geex-content__todo__list\">
                            <div class=\"geex-content__todo__list__single geex-content__todo__list__single--header\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-1\" id=\"invoice-1\" />
                                    <label for=\"invoice-1\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">Invoice Number</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Receipent</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Date</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Amount</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Status</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Action</span>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-11\" id=\"invoice-11\" />
                                    <label for=\"invoice-11\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231255</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user1.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Samuel</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 1/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$549.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-12\" id=\"invoice-12\" />
                                    <label for=\"invoice-12\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231256</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user2.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Bella</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 2/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$876.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-13\" id=\"invoice-13\" />
                                    <label for=\"invoice-13\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231257</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user3.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Dejon</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 3/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$146.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-14\" id=\"invoice-14\" />
                                    <label for=\"invoice-14\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231262</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user4.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">William</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 5/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$346.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-15\" id=\"invoice-15\" />
                                    <label for=\"invoice-15\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231235</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user5.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Lurile</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 1/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$749.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class=\"tab-pane fade\" id=\"invoice_grid_content\" role=\"tabpanel\" aria-labelledby=\"invoice_grid_tab\">
                        <div class=\"geex-content__todo__list geex-content__todo__list--grid\">
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-21\" id=\"invoice-21\" />
                                    <label for=\"invoice-21\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231255</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user1.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Samuel</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 1/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$549.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-22\" id=\"invoice-22\" />
                                    <label for=\"invoice-22\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231256</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user2.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Bella</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 2/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$876.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-23\" id=\"invoice-23\" />
                                    <label for=\"invoice-23\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231257</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user3.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Dejon</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 3/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$146.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-24\" id=\"invoice-24\" />
                                    <label for=\"invoice-24\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231262</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user4.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">William</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 5/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$346.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class=\"geex-content__todo__list__single\">
                                <div class=\"geex-content__todo__list__single__checkbox\">
                                    <input type=\"checkbox\" name=\"invoice-25\" id=\"invoice-30\" />
                                    <label for=\"invoice-30\">
                                        <i class=\"uil-check\"></i>
                                    </label>
                                    <span class=\"geex-content__todo__list__single__subtitle\">#INV-001231235</span>
                                </div>
            
                                <div class=\"geex-content__todo__list__single__author\">
                                    <img src=\"assets/img/avatar/user5.svg\" alt=\"User\" />
                                    <span class=\"geex-content__todo__list__single__subtitle\">Lurile</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">Thu 1/7/2021 5:24 AM</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-content__todo__list__single__subtitle\">\$749.09</span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <span class=\"geex-badge geex-badge--success-transparent\">
                                        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                                            <path d=\"M12 1.00003C9.82441 1.00003 7.69767 1.64517 5.88873 2.85386C4.07979 4.06256 2.66989 5.78053 1.83733 7.79051C1.00477 9.8005 0.786929 12.0122 1.21137 14.146C1.6358 16.2798 2.68345 18.2398 4.22183 19.7782C5.76021 21.3166 7.72022 22.3642 9.85401 22.7887C11.9878 23.2131 14.1995 22.9953 16.2095 22.1627C18.2195 21.3301 19.9375 19.9202 21.1462 18.1113C22.3549 16.3024 23 14.1756 23 12C22.9966 9.0837 21.8365 6.28781 19.7744 4.22566C17.7122 2.1635 14.9163 1.00347 12 1.00003V1.00003ZM12 21C10.22 21 8.47992 20.4722 6.99987 19.4833C5.51983 18.4943 4.36628 17.0887 3.68509 15.4442C3.0039 13.7996 2.82567 11.99 3.17294 10.2442C3.5202 8.49839 4.37737 6.89474 5.63604 5.63607C6.89472 4.3774 8.49836 3.52023 10.2442 3.17296C11.99 2.8257 13.7996 3.00393 15.4442 3.68511C17.0887 4.3663 18.4943 5.51986 19.4832 6.9999C20.4722 8.47994 21 10.22 21 12C20.9974 14.3862 20.0483 16.6738 18.361 18.3611C16.6738 20.0483 14.3861 20.9974 12 21V21Z\" fill=\"#00A389\"/>
                                            <path d=\"M16.3236 8.76298L11.0296 13.616L8.70659 11.293C8.61435 11.1975 8.504 11.1213 8.382 11.0689C8.25999 11.0165 8.12877 10.9889 7.99599 10.9877C7.86321 10.9866 7.73154 11.0119 7.60864 11.0622C7.48574 11.1124 7.37409 11.1867 7.2802 11.2806C7.18631 11.3745 7.11205 11.4861 7.06177 11.609C7.01149 11.7319 6.98619 11.8636 6.98734 11.9964C6.9885 12.1292 7.01608 12.2604 7.06849 12.3824C7.1209 12.5044 7.19708 12.6147 7.29259 12.707L10.2926 15.707C10.4748 15.8892 10.7204 15.9941 10.9781 15.9997C11.2357 16.0053 11.4856 15.9112 11.6756 15.737L17.6756 10.237C17.8711 10.0577 17.9873 9.8081 17.9987 9.54312C18.0102 9.27813 17.9159 9.01945 17.7366 8.82398C17.5573 8.62852 17.3077 8.51228 17.0427 8.50084C16.7777 8.4894 16.5191 8.58369 16.3236 8.76298V8.76298Z\" fill=\"#00A389\"/>
                                        </svg>
                                        Paid
                                    </span>
                                </div>

                                <div class=\"geex-content__todo__list__single__text\">
                                    <div class=\"geex-content__todo__list__single__action\">
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M20.382 13.1751C20.2706 13.2827 20.1817 13.4115 20.1206 13.5538C20.0594 13.6962 20.0272 13.8492 20.0259 14.0042C20.0245 14.1591 20.0541 14.3127 20.1127 14.4561C20.1714 14.5995 20.258 14.7297 20.3675 14.8393C20.4771 14.9488 20.6073 15.0354 20.7507 15.0941C20.8941 15.1527 21.0477 15.1823 21.2026 15.1809C21.3575 15.1796 21.5106 15.1474 21.653 15.0862C21.7953 15.0251 21.9241 14.9362 22.0317 14.8248L23.833 13.0235C24.9853 11.8445 25.6262 10.2587 25.6167 8.61024C25.6073 6.96173 24.9482 5.38343 23.7826 4.21775C22.6169 3.05206 21.0386 2.393 19.3901 2.38356C17.7416 2.37411 16.1558 3.01504 14.9768 4.16729L13.1755 5.96863C13.0641 6.07625 12.9752 6.20498 12.9141 6.34732C12.8529 6.48966 12.8207 6.64275 12.8194 6.79766C12.818 6.95257 12.8476 7.10619 12.9062 7.24957C12.9649 7.39295 13.0515 7.52321 13.161 7.63275C13.2706 7.7423 13.4008 7.82892 13.5442 7.88759C13.6876 7.94625 13.8412 7.97577 13.9961 7.97442C14.151 7.97307 14.3041 7.94089 14.4465 7.87975C14.5888 7.8186 14.7176 7.72972 14.8252 7.61829L16.6265 5.81696C16.9906 5.44881 17.424 5.15627 17.9015 4.95615C18.3791 4.75603 18.8916 4.65227 19.4094 4.65086C19.9272 4.64944 20.4402 4.75039 20.9188 4.94789C21.3975 5.1454 21.8324 5.43557 22.1986 5.80172C22.5647 6.16787 22.8549 6.60278 23.0524 7.08145C23.2499 7.56012 23.3509 8.07311 23.3494 8.59093C23.348 9.10874 23.2443 9.62117 23.0442 10.0987C22.844 10.5763 22.5515 11.0097 22.1833 11.3738L20.382 13.1751Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M7.61863 14.8248C7.73006 14.7172 7.81894 14.5884 7.88008 14.4461C7.94123 14.3037 7.97341 14.1507 7.97476 13.9957C7.9761 13.8408 7.94658 13.6872 7.88792 13.5438C7.82926 13.4005 7.74263 13.2702 7.63309 13.1606C7.52355 13.0511 7.39329 12.9645 7.24991 12.9058C7.10653 12.8472 6.9529 12.8176 6.798 12.819C6.64309 12.8203 6.49 12.8525 6.34766 12.9137C6.20532 12.9748 6.07658 13.0637 5.96896 13.1751L4.16763 14.9764C3.01537 16.1554 2.37445 17.7412 2.38389 19.3897C2.39334 21.0382 3.05239 22.6165 4.21808 23.7822C5.38377 24.9478 6.96207 25.6069 8.61058 25.6163C10.2591 25.6258 11.8448 24.9849 13.0238 23.8326L14.8251 22.0313C15.0376 21.8112 15.1552 21.5165 15.1526 21.2106C15.1499 20.9047 15.0272 20.6121 14.8109 20.3958C14.5946 20.1795 14.302 20.0568 13.9961 20.0542C13.6902 20.0515 13.3955 20.1691 13.1755 20.3816L11.3741 22.1829C10.6359 22.9132 9.63856 23.3215 8.60017 23.3186C7.56177 23.3158 6.56672 22.902 5.83246 22.1678C5.0982 21.4335 4.68443 20.4385 4.68159 19.4001C4.67875 18.3617 5.08706 17.3644 5.8173 16.6261L7.61863 14.8248Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M9.57303 18.4334C9.79181 18.6521 10.0885 18.775 10.3979 18.775C10.7072 18.775 11.0039 18.6521 11.2227 18.4334L18.4339 11.2222C18.5453 11.1146 18.6342 10.9859 18.6953 10.8435C18.7565 10.7012 18.7886 10.5481 18.79 10.3932C18.7913 10.2383 18.7618 10.0847 18.7031 9.94129C18.6445 9.79791 18.5579 9.66765 18.4483 9.55811C18.3388 9.44857 18.2085 9.36194 18.0651 9.30328C17.9218 9.24462 17.7681 9.2151 17.6132 9.21644C17.4583 9.21779 17.3052 9.24997 17.1629 9.31112C17.0205 9.37226 16.8918 9.46114 16.7842 9.57257L9.57303 16.7779C9.46385 16.8863 9.37721 17.0153 9.31808 17.1574C9.25895 17.2994 9.22852 17.4518 9.22852 17.6057C9.22852 17.7595 9.25895 17.9119 9.31808 18.0539C9.37721 18.196 9.46385 18.325 9.57303 18.4334Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M24.5007 9.33328H21.0007V3.49995C21.0007 3.19053 20.8777 2.89378 20.6589 2.67499C20.4402 2.4562 20.1434 2.33328 19.834 2.33328H8.16732C7.8579 2.33328 7.56115 2.4562 7.34236 2.67499C7.12357 2.89378 7.00065 3.19053 7.00065 3.49995V9.33328H3.50065C3.19123 9.33328 2.89449 9.4562 2.67569 9.67499C2.4569 9.89378 2.33398 10.1905 2.33398 10.4999V19.8333C2.33398 20.1427 2.4569 20.4394 2.67569 20.6582C2.89449 20.877 3.19123 21 3.50065 21H7.00065V24.5C7.00065 24.8094 7.12357 25.1061 7.34236 25.3249C7.56115 25.5437 7.8579 25.6666 8.16732 25.6666H19.834C20.1434 25.6666 20.4402 25.5437 20.6589 25.3249C20.8777 25.1061 21.0007 24.8094 21.0007 24.5V21H24.5007C24.8101 21 25.1068 20.877 25.3256 20.6582C25.5444 20.4394 25.6673 20.1427 25.6673 19.8333V10.4999C25.6673 10.1905 25.5444 9.89378 25.3256 9.67499C25.1068 9.4562 24.8101 9.33328 24.5007 9.33328ZM9.33398 4.66662H18.6673V9.33328H9.33398V4.66662ZM18.6673 23.3333H9.33398V17.5H18.6673V23.3333ZM23.334 18.6666H21.0007V16.3333C21.0007 16.0239 20.8777 15.7271 20.6589 15.5083C20.4402 15.2895 20.1434 15.1666 19.834 15.1666H8.16732C7.8579 15.1666 7.56115 15.2895 7.34236 15.5083C7.12357 15.7271 7.00065 16.0239 7.00065 16.3333V18.6666H4.66732V11.6666H23.334V18.6666Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <button class=\"geex-content__todo__list__single__action__btn geex-content__toggle__btn\">
                                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                                <path d=\"M5.83333 16.3333C7.12199 16.3333 8.16666 15.2887 8.16666 14C8.16666 12.7113 7.12199 11.6667 5.83333 11.6667C4.54467 11.6667 3.5 12.7113 3.5 14C3.5 15.2887 4.54467 16.3333 5.83333 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M14.0003 16.3333C15.289 16.3333 16.3337 15.2887 16.3337 14C16.3337 12.7113 15.289 11.6667 14.0003 11.6667C12.7117 11.6667 11.667 12.7113 11.667 14C11.667 15.2887 12.7117 16.3333 14.0003 16.3333Z\" fill=\"#A3A3A3\"/>
                                                <path d=\"M22.1663 16.3333C23.455 16.3333 24.4997 15.2887 24.4997 14C24.4997 12.7113 23.455 11.6667 22.1663 11.6667C20.8777 11.6667 19.833 12.7113 19.833 14C19.833 15.2887 20.8777 16.3333 22.1663 16.3333Z\" fill=\"#A3A3A3\"/>
                                            </svg>
                                        </button>
                                        <ul class=\"geex-content__todo__list__single__action__content geex-content__toggle__content \">
                                            <li><a href=\"#\">Edit</a></li>
                                            <li><a href=\"#\">Delete</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class=\"geex-content__invoice__chat\">
                <button class=\"geex-content__invoice__chat__toggler\">
                    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\">
                        <path d=\"M3 13H18.59L13.29 18.29C13.1963 18.383 13.1219 18.4936 13.0711 18.6154C13.0203 18.7373 12.9942 18.868 12.9942 19C12.9942 19.132 13.0203 19.2627 13.0711 19.3846C13.1219 19.5064 13.1963 19.617 13.29 19.71C13.383 19.8037 13.4936 19.8781 13.6154 19.9289C13.7373 19.9797 13.868 20.0058 14 20.0058C14.132 20.0058 14.2627 19.9797 14.3846 19.9289C14.5064 19.8781 14.617 19.8037 14.71 19.71L21.71 12.71C21.8037 12.617 21.8781 12.5064 21.9289 12.3846C21.9797 12.2627 22.0058 12.132 22.0058 12C22.0058 11.868 21.9797 11.7373 21.9289 11.6154C21.8781 11.4936 21.8037 11.383 21.71 11.29L14.71 4.29C14.6168 4.19676 14.5061 4.1228 14.3843 4.07234C14.2624 4.02188 14.1319 3.99591 14 3.99591C13.7337 3.99591 13.4783 4.1017 13.29 4.29C13.1968 4.38324 13.1228 4.49393 13.0723 4.61575C13.0219 4.73758 12.9959 4.86814 12.9959 5C12.9959 5.2663 13.1017 5.5217 13.29 5.71L18.59 11H3C2.73478 11 2.48043 11.1054 2.29289 11.2929C2.10536 11.4804 2 11.7348 2 12C2 12.2652 2.10536 12.5196 2.29289 12.7071C2.48043 12.8946 2.73478 13 3 13Z\" fill=\"#464255\"/>
                    </svg>
                </button>

                <div class=\"geex-content__invoice__chat__wrapper\">
                    <div class=\"geex-content__todo__header\">
                        <div class=\"geex-content__todo__header__title\">
                            <h4>Send Invoices</h4>
                            <p>Eum fuga consequuntur ut et.</p>
                        </div>
                    </div>

                    <div class=\"geex-content__invoice__chat__content\">
                        <div class=\"geex-content__invoice__chat__content__single\">
                            <span class=\"geex-content__invoice__chat__subtitle\">
                                Choose Receipent
                            </span>
                            <div class=\"geex-content__invoice__chat__author\">
                                <a href=\"#\" class=\"geex-content__invoice__chat__author__single\">
                                    <img src=\"assets/img/avatar/user1.svg\" alt=\"User\" />
                                    <span class=\"geex-content__invoice__chat__author__single__name\">Dave</span>
                                </a>
                                <a href=\"#\" class=\"geex-content__invoice__chat__author__single\">
                                    <img src=\"assets/img/avatar/user2.svg\" alt=\"User\" />
                                    <span class=\"geex-content__invoice__chat__author__single__name\">Ismael</span>
                                </a>
                                <a href=\"#\" class=\"geex-content__invoice__chat__author__single\">
                                    <img src=\"assets/img/avatar/user3.svg\" alt=\"User\" />
                                    <span class=\"geex-content__invoice__chat__author__single__name\">Dinda</span>
                                </a>
                            </div>
                        </div>
                        <div class=\"geex-content__invoice__chat__content__single\">
                            <span class=\"geex-content__invoice__chat__subtitle\">
                                Choose Service
                            </span>
                            <div class=\"geex-content__invoice__chat__service\">
                                <select id=\"selectService\" class=\"invoice_service\">
                                    <option value=\"service\">Maintenance Service</option>
                                    <option value=\"service1\">Service One</option>
                                    <option value=\"service2\">Service Two</option>
                                    <option value=\"service3\">Service Three</option>
                                </select>
                                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                    <path d=\"M13.9873 19.217C13.7177 19.2146 13.4596 19.1076 13.2674 18.9186L3.08562 8.73681C2.90015 8.54478 2.79752 8.28759 2.79984 8.02062C2.80216 7.75366 2.90924 7.49829 3.09802 7.30951C3.2868 7.12073 3.54217 7.01365 3.80914 7.01133C4.0761 7.00901 4.3333 7.11164 4.52533 7.29711L13.9873 16.7591L23.4493 7.29711C23.5432 7.19986 23.6555 7.12229 23.7798 7.06893C23.904 7.01557 24.0376 6.98748 24.1728 6.98631C24.308 6.98513 24.442 7.01089 24.5672 7.06209C24.6923 7.11328 24.806 7.18889 24.9016 7.28449C24.9972 7.38009 25.0728 7.49377 25.124 7.6189C25.1752 7.74403 25.2009 7.8781 25.1998 8.0133C25.1986 8.14849 25.1705 8.2821 25.1171 8.40632C25.0638 8.53054 24.9862 8.64289 24.889 8.73681L14.7071 18.9186C14.515 19.1076 14.2568 19.2146 13.9873 19.217Z\" fill=\"#AB54DB\"/>
                                </svg>
                            </div>
                        </div>
                        <div class=\"geex-content__invoice__chat__content__single\">
                            <span class=\"geex-content__invoice__chat__subtitle\">
                                Label
                            </span>
                            <div class=\"geex-content__invoice__chat__amount\">
                                <label for=\"invoice_amount\">
                                    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                        <path d=\"M14 10.5H16.3333C16.6428 10.5 16.9395 10.3771 17.1583 10.1583C17.3771 9.9395 17.5 9.64275 17.5 9.33333C17.5 9.02391 17.3771 8.72717 17.1583 8.50838C16.9395 8.28958 16.6428 8.16667 16.3333 8.16667H15.1667C15.1667 7.85725 15.0437 7.5605 14.825 7.34171C14.6062 7.12292 14.3094 7 14 7C13.6906 7 13.3938 7.12292 13.175 7.34171C12.9562 7.5605 12.8333 7.85725 12.8333 8.16667V8.37667C12.0617 8.65664 11.4131 9.1989 11.0008 9.90865C10.5885 10.6184 10.4387 11.4505 10.5777 12.2595C10.7167 13.0684 11.1356 13.8028 11.7612 14.3342C12.3868 14.8657 13.1792 15.1603 14 15.1667C14.3094 15.1667 14.6062 15.2896 14.825 15.5084C15.0437 15.7272 15.1667 16.0239 15.1667 16.3333C15.1667 16.6428 15.0437 16.9395 14.825 17.1583C14.6062 17.3771 14.3094 17.5 14 17.5H11.6667C11.3572 17.5 11.0605 17.6229 10.8417 17.8417C10.6229 18.0605 10.5 18.3572 10.5 18.6667C10.5 18.9761 10.6229 19.2728 10.8417 19.4916C11.0605 19.7104 11.3572 19.8333 11.6667 19.8333H12.8333C12.8333 20.1428 12.9562 20.4395 13.175 20.6583C13.3938 20.8771 13.6906 21 14 21C14.3094 21 14.6062 20.8771 14.825 20.6583C15.0437 20.4395 15.1667 20.1428 15.1667 19.8333V19.6233C15.9383 19.3434 16.5869 18.8011 16.9992 18.0913C17.4115 17.3816 17.5613 16.5495 17.4223 15.7405C17.2833 14.9316 16.8644 14.1972 16.2388 13.6658C15.6132 13.1343 14.8208 12.8397 14 12.8333C13.6906 12.8333 13.3938 12.7104 13.175 12.4916C12.9562 12.2728 12.8333 11.9761 12.8333 11.6667C12.8333 11.3572 12.9562 11.0605 13.175 10.8417C13.3938 10.6229 13.6906 10.5 14 10.5Z\" fill=\"#A3A3A3\"/>
                                        <path d=\"M14.0007 2.33337C11.6932 2.33337 9.43758 3.01761 7.519 4.29956C5.60043 5.58151 4.10508 7.4036 3.22206 9.5354C2.33904 11.6672 2.108 14.013 2.55816 16.2761C3.00832 18.5392 4.11946 20.618 5.75108 22.2496C7.38269 23.8812 9.46149 24.9924 11.7246 25.4425C13.9877 25.8927 16.3335 25.6617 18.4653 24.7786C20.5971 23.8956 22.4192 22.4003 23.7011 20.4817C24.9831 18.5631 25.6673 16.3075 25.6673 14C25.6673 12.468 25.3656 10.9509 24.7793 9.5354C24.1929 8.11994 23.3336 6.83381 22.2502 5.75046C21.1669 4.66711 19.8808 3.80775 18.4653 3.22145C17.0498 2.63514 15.5327 2.33337 14.0007 2.33337ZM14.0007 23.3334C12.1547 23.3334 10.3502 22.786 8.81533 21.7604C7.28047 20.7349 6.0842 19.2772 5.37778 17.5718C4.67136 15.8663 4.48653 13.9897 4.84666 12.1792C5.20679 10.3687 6.0957 8.70567 7.40099 7.40038C8.70628 6.09509 10.3693 5.20617 12.1798 4.84605C13.9903 4.48592 15.8669 4.67075 17.5724 5.37717C19.2778 6.08358 20.7355 7.27986 21.761 8.81472C22.7866 10.3496 23.334 12.1541 23.334 14C23.334 16.4754 22.3507 18.8494 20.6003 20.5997C18.85 22.35 16.476 23.3334 14.0007 23.3334Z\" fill=\"#A3A3A3\"/>
                                    </svg>
                                </label>
                                <input type=\"number\" id=\"invoice_amount\" name=\"invoice_amount\" placeholder=\"Insert amount\" />
                            </div>
                        </div>
                        <button class=\"geex-content__invoice__chat__btn geex-btn geex-btn--primary\">
                            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\">
                                <path d=\"M26.7077 1.29306C26.572 1.15701 26.3999 1.06296 26.2121 1.02217C26.0243 0.981382 25.8287 0.995577 25.6487 1.06306L2.49472 9.74606C2.0738 9.90231 1.70781 10.1783 1.4419 10.5401C1.17598 10.9019 1.02177 11.3336 0.99827 11.7819C0.974772 12.2303 1.08302 12.6757 1.30966 13.0633C1.53631 13.4509 1.87144 13.7637 2.27372 13.9631L10.1157 17.8841L14.0367 25.7261C14.2244 26.1102 14.5168 26.4336 14.8802 26.659C15.2435 26.8844 15.6631 27.0026 16.0907 27.0001H16.2177C16.6665 26.9803 17.0994 26.8282 17.4619 26.5628C17.8244 26.2975 18.1002 25.9309 18.2547 25.5091L26.9377 2.35106C27.005 2.17124 27.0191 1.97585 26.9783 1.78824C26.9375 1.60063 26.8436 1.42872 26.7077 1.29306V1.29306ZM16.3817 24.8001C16.3634 24.8573 16.3276 24.9074 16.2793 24.9432C16.2311 24.9791 16.1728 24.999 16.1127 25.0001C16.0536 25.0035 15.9949 24.9894 15.9438 24.9595C15.8927 24.9296 15.8517 24.8852 15.8257 24.8321L12.0777 17.3321L16.7077 12.7021C16.8899 12.5135 16.9907 12.2609 16.9884 11.9987C16.9861 11.7365 16.8809 11.4856 16.6955 11.3002C16.5101 11.1148 16.2593 11.0097 15.9971 11.0074C15.7349 11.0051 15.4823 11.1059 15.2937 11.2881L10.6637 15.9181L3.16872 12.1751C3.11439 12.1499 3.06884 12.109 3.03794 12.0577C3.00703 12.0064 2.99218 11.9471 2.9953 11.8873C2.99842 11.8275 3.01937 11.77 3.05544 11.7222C3.09151 11.6744 3.14107 11.6385 3.19772 11.6191L24.2917 3.70906L16.3817 24.8001Z\" fill=\"white\"/>
                            </svg>
                            Send Invoices
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

{% endblock %}
", "home/index4.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\home\\index4.html.twig");
    }
}
