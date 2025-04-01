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

/* features/form.html.twig */
class __TwigTemplate_311419ff9825c31db48e27516ff8c7be extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "features/form.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "features/form.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "features/form.html.twig", 1);
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

        yield "Form - Geex Dashboard";
        
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

        yield "Form";
        
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
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Textarea</h4>
                <div class=\"geex-content__form__single__box\">
                    <textarea class=\"form-control\" id=\"geex-textarea1\" rows=\"5\"></textarea>
                    <textarea class=\"form-control\" id=\"geex-textarea2\" rows=\"5\"></textarea>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Search Box</h4>
    <div class=\"geex-content__header__searchform\">
    <input type=\"text\" id=\"search2\" placeholder=\"Search\" class=\"geex-content__header__btn\">
    <i class=\"uil uil-search\"></i>
    </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Checkbox</h4>
                <div class=\"geex-content__form__single__box\">
                    <div class=\"form-check success\">
        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"geex-checkbox1\" />
        <label class=\"form-check-label\" for=\"geex-checkbox1\">
        Checkbox 1
        </label>
    </div>
                    <div class=\"form-check warning\">
        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"geex-checkbox2\" />
        <label class=\"form-check-label\" for=\"geex-checkbox2\">
        Checkbox 2
        </label>
    </div>
                    <div class=\"form-check danger\">
        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"geex-checkbox3\" />
        <label class=\"form-check-label\" for=\"geex-checkbox3\">
        Checkbox 3
        </label>
    </div>
                    <div class=\"form-check info\">
        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"geex-checkbox4\" />
        <label class=\"form-check-label\" for=\"geex-checkbox4\">
        Checkbox 4
        </label>
    </div>
                    <div class=\"form-check default\">
        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"geex-checkbox5\" />
        <label class=\"form-check-label\" for=\"geex-checkbox5\">
        Checkbox 5
        </label>
    </div>
                </div>
            </div>
        </div>
        <div class=\"geex-content__form__wrapper__item geex-content__form__right\">
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Default Input</h4>
                <div class=\"geex-content__form__single__box mb-20\">
                    <input placeholder=\"Insert amount\" class=\"form-control\" id=\"geex-input1\" />
                    <input placeholder=\"Insert amount\" class=\"form-control\" id=\"geex-input2\" />
                </div>
                <div class=\"geex-content__form__single__box\">
                    <div class=\"input-icon\">
        <i class=\"uil uil-dollar-alt\"></i>
        <input placeholder=\"@ Insert amount\" class=\"form-control\" id=\"geex-input1\" />
    </div>
    <div class=\"input-icon\">
        <i class=\"uil uil-dollar-alt\"></i>
        <input placeholder=\"@ Insert amount\" class=\"form-control\" id=\"geex-input2\" />
    </div>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Default Input With Label</h4>
                <div class=\"geex-content__form__single__box mb-20\">
    <div class=\"input-wrapper\">
        <label for=\"geex-input-5\" class=\"input-label\">Label</label>
        <input placeholder=\"Insert amount\" class=\"form-control\" id=\"geex-input5\" />
    </div>
    <div class=\"input-wrapper\">
        <label for=\"geex-input-6\" class=\"input-label\">Label</label>
        <input placeholder=\"Insert amount\" class=\"form-control\" id=\"geex-input6\" />
    </div>
                </div>
                <div class=\"geex-content__form__single__box\">
    <div class=\"input-wrapper input-icon\">
        <label for=\"geex-input-7\" class=\"input-label\">Label</label>
        <input placeholder=\"Insert amount\" class=\"form-control\" id=\"geex-input7\" />
        <i class=\"uil uil-dollar-alt\"></i>
    </div>
    <div class=\"input-wrapper input-icon\">
        <label for=\"geex-input-8\" class=\"input-label\">Label</label>
        <input placeholder=\"Insert amount\" class=\"form-control\" id=\"geex-input8\" />
        <i class=\"uil uil-dollar-alt\"></i>
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
        return "features/form.html.twig";
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

{% block title %}Form - Geex Dashboard{% endblock %}

{% block mainHeader %}Form{% endblock %}

{% block content %}Form Elements is used to style and format the input field{% endblock %}

{% block body %}

<div class=\"geex-content__section geex-content__form\">
    <div class=\"geex-content__form__wrapper\">
        <div class=\"geex-content__form__wrapper__item geex-content__form__left\">
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Textarea</h4>
                <div class=\"geex-content__form__single__box\">
                    <textarea class=\"form-control\" id=\"geex-textarea1\" rows=\"5\"></textarea>
                    <textarea class=\"form-control\" id=\"geex-textarea2\" rows=\"5\"></textarea>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Search Box</h4>
    <div class=\"geex-content__header__searchform\">
    <input type=\"text\" id=\"search2\" placeholder=\"Search\" class=\"geex-content__header__btn\">
    <i class=\"uil uil-search\"></i>
    </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Checkbox</h4>
                <div class=\"geex-content__form__single__box\">
                    <div class=\"form-check success\">
        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"geex-checkbox1\" />
        <label class=\"form-check-label\" for=\"geex-checkbox1\">
        Checkbox 1
        </label>
    </div>
                    <div class=\"form-check warning\">
        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"geex-checkbox2\" />
        <label class=\"form-check-label\" for=\"geex-checkbox2\">
        Checkbox 2
        </label>
    </div>
                    <div class=\"form-check danger\">
        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"geex-checkbox3\" />
        <label class=\"form-check-label\" for=\"geex-checkbox3\">
        Checkbox 3
        </label>
    </div>
                    <div class=\"form-check info\">
        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"geex-checkbox4\" />
        <label class=\"form-check-label\" for=\"geex-checkbox4\">
        Checkbox 4
        </label>
    </div>
                    <div class=\"form-check default\">
        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"geex-checkbox5\" />
        <label class=\"form-check-label\" for=\"geex-checkbox5\">
        Checkbox 5
        </label>
    </div>
                </div>
            </div>
        </div>
        <div class=\"geex-content__form__wrapper__item geex-content__form__right\">
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Default Input</h4>
                <div class=\"geex-content__form__single__box mb-20\">
                    <input placeholder=\"Insert amount\" class=\"form-control\" id=\"geex-input1\" />
                    <input placeholder=\"Insert amount\" class=\"form-control\" id=\"geex-input2\" />
                </div>
                <div class=\"geex-content__form__single__box\">
                    <div class=\"input-icon\">
        <i class=\"uil uil-dollar-alt\"></i>
        <input placeholder=\"@ Insert amount\" class=\"form-control\" id=\"geex-input1\" />
    </div>
    <div class=\"input-icon\">
        <i class=\"uil uil-dollar-alt\"></i>
        <input placeholder=\"@ Insert amount\" class=\"form-control\" id=\"geex-input2\" />
    </div>
                </div>
            </div>
            <div class=\"geex-content__form__single\">
                <h4 class=\"geex-content__form__single__label\">Default Input With Label</h4>
                <div class=\"geex-content__form__single__box mb-20\">
    <div class=\"input-wrapper\">
        <label for=\"geex-input-5\" class=\"input-label\">Label</label>
        <input placeholder=\"Insert amount\" class=\"form-control\" id=\"geex-input5\" />
    </div>
    <div class=\"input-wrapper\">
        <label for=\"geex-input-6\" class=\"input-label\">Label</label>
        <input placeholder=\"Insert amount\" class=\"form-control\" id=\"geex-input6\" />
    </div>
                </div>
                <div class=\"geex-content__form__single__box\">
    <div class=\"input-wrapper input-icon\">
        <label for=\"geex-input-7\" class=\"input-label\">Label</label>
        <input placeholder=\"Insert amount\" class=\"form-control\" id=\"geex-input7\" />
        <i class=\"uil uil-dollar-alt\"></i>
    </div>
    <div class=\"input-wrapper input-icon\">
        <label for=\"geex-input-8\" class=\"input-label\">Label</label>
        <input placeholder=\"Insert amount\" class=\"form-control\" id=\"geex-input8\" />
        <i class=\"uil uil-dollar-alt\"></i>
    </div>
                </div>
            </div>
        </div>
    </div>
</div>

{% endblock %}
", "features/form.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\features\\form.html.twig");
    }
}
