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

/* partials/customizer.html.twig */
class __TwigTemplate_85bc8f61788e744cc937194de3a4fd29 extends Template
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

        $this->parent = false;

        $this->blocks = [
        ];
    }

    protected function doDisplay(array $context, array $blocks = []): iterable
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "partials/customizer.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "partials/customizer.html.twig"));

        // line 1
        yield "<div class=\"geex-customizer\">
\t<div class=\"geex-customizer__header\">
\t\t<h4 class=\"geex-customizer__title\">Customizer</h4>
\t\t<button class=\"geex-btn geex-btn__customizer-close\">
\t\t\t<svg width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t<path d=\"M18 7.05L16.95 6L12 10.95L7.05 6L6 7.05L10.95 12L6 16.95L7.05 18L12 13.05L16.95 18L18 16.95L13.05 12L18 7.05Z\" fill=\"#BCBFDB\"/>
\t\t\t\t<path d=\"M18 7.05L16.95 6L12 10.95L7.05 6L6 7.05L10.95 12L6 16.95L7.05 18L12 13.05L16.95 18L18 16.95L13.05 12L18 7.05Z\" fill=\"black\" fill-opacity=\"0.8\"/>
\t\t\t</svg>
\t\t</button>
\t</div>
\t<div class=\"geex-customizer__body\">
\t\t<div class=\"geex-customizer__single\">
\t\t\t<h5 class=\"geex-customizer__single__title\">Layout Types</h5>
\t\t\t<ul class=\"geex-customizer__list geex-customizer__list--layout\">
\t\t\t\t<li class=\"geex-customizer__list__item\">
\t\t\t\t\t<button class=\"geex-btn geex-customizer__btn geex-customizer__btn--ltr active\">
\t\t\t\t\t\t<svg width=\"24\" height=\"20\" viewBox=\"0 0 24 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t<rect x=\"4.5\" y=\"2.5\" width=\"13\" height=\"5\" rx=\"1.5\" stroke=\"white\"/>
\t\t\t\t\t\t\t<rect x=\"4.5\" y=\"12.5\" width=\"19\" height=\"5\" rx=\"1.5\" stroke=\"white\"/>
\t\t\t\t\t\t\t<rect width=\"1\" height=\"20\" fill=\"white\"/>
\t\t\t\t\t\t</svg>
\t\t\t\t\t\tLTR
\t\t\t\t\t</button>
\t\t\t\t</li>
\t\t\t\t<li class=\"geex-customizer__list__item\">
\t\t\t\t\t<button class=\"geex-btn geex-customizer__btn geex-customizer__btn--rtl\">
\t\t\t\t\t\tRTL
\t\t\t\t\t\t<svg width=\"24\" height=\"20\" viewBox=\"0 0 24 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t<rect x=\"-0.5\" y=\"0.5\" width=\"13\" height=\"5\" rx=\"1.5\" transform=\"matrix(-1 0 0 1 19 2)\" stroke=\"#AB54DB\"/>
\t\t\t\t\t\t\t<rect x=\"-0.5\" y=\"0.5\" width=\"19\" height=\"5\" rx=\"1.5\" transform=\"matrix(-1 0 0 1 19 12)\" stroke=\"#AB54DB\"/>
\t\t\t\t\t\t\t<rect width=\"1\" height=\"20\" transform=\"matrix(-1 0 0 1 24 0)\" fill=\"#AB54DB\"/>
\t\t\t\t\t\t</svg>\t\t\t\t\t\t\t\t\t
\t\t\t\t\t</button>
\t\t\t\t</li>
\t\t\t</ul>
\t\t</div>
\t\t<div class=\"geex-customizer__single\">
\t\t\t<h4 class=\"geex-customizer__single__title\">Mode Type</h4>
\t\t\t<ul class=\"geex-customizer__list geex-customizer__list--sidebar\">
\t\t\t\t<li class=\"geex-customizer__list__item\">
\t\t\t\t\t<button class=\"geex-btn geex-customizer__btn geex-customizer__btn--light active\">
\t\t\t\t\t\t<svg width=\"144\" height=\"86\" viewBox=\"0 0 144 86\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t<rect width=\"144\" height=\"86\" rx=\"10\" fill=\"white\"/>
\t\t\t\t\t\t\t<circle cx=\"27\" cy=\"22\" r=\"4\" fill=\"#FF5653\"/>
\t\t\t\t\t\t\t<circle cx=\"38\" cy=\"22\" r=\"4\" fill=\"#FDB23A\"/>
\t\t\t\t\t\t\t<circle cx=\"49\" cy=\"22\" r=\"4\" fill=\"#2CBF44\"/>
\t\t\t\t\t\t\t<rect x=\"22\" y=\"36\" width=\"110\" height=\"1\" fill=\"#E7E7E7\"/>
\t\t\t\t\t\t\t<path d=\"M31.94 58.34H26.38L25.46 61H22.52L27.54 47.02H30.8L35.82 61H32.86L31.94 58.34ZM31.18 56.1L29.16 50.26L27.14 56.1H31.18ZM36.9764 55.42C36.9764 54.3 37.1964 53.3067 37.6364 52.44C38.0897 51.5733 38.6964 50.9067 39.4564 50.44C40.2297 49.9733 41.0897 49.74 42.0364 49.74C42.8631 49.74 43.5831 49.9067 44.1964 50.24C44.8231 50.5733 45.3231 50.9933 45.6964 51.5V49.92H48.5164V61H45.6964V59.38C45.3364 59.9 44.8364 60.3333 44.1964 60.68C43.5697 61.0133 42.8431 61.18 42.0164 61.18C41.0831 61.18 40.2297 60.94 39.4564 60.46C38.6964 59.98 38.0897 59.3067 37.6364 58.44C37.1964 57.56 36.9764 56.5533 36.9764 55.42ZM45.6964 55.46C45.6964 54.78 45.5631 54.2 45.2964 53.72C45.0297 53.2267 44.6697 52.8533 44.2164 52.6C43.7631 52.3333 43.2764 52.2 42.7564 52.2C42.2364 52.2 41.7564 52.3267 41.3164 52.58C40.8764 52.8333 40.5164 53.2067 40.2364 53.7C39.9697 54.18 39.8364 54.7533 39.8364 55.42C39.8364 56.0867 39.9697 56.6733 40.2364 57.18C40.5164 57.6733 40.8764 58.0533 41.3164 58.32C41.7697 58.5867 42.2497 58.72 42.7564 58.72C43.2764 58.72 43.7631 58.5933 44.2164 58.34C44.6697 58.0733 45.0297 57.7 45.2964 57.22C45.5631 56.7267 45.6964 56.14 45.6964 55.46Z\" fill=\"#464255\"/>
\t\t\t\t\t\t</svg>\t\t\t\t\t\t\t
\t\t\t\t\t</button>
\t\t\t\t</li>
\t\t\t\t<li class=\"geex-customizer__list__item\">
\t\t\t\t\t<button class=\"geex-btn geex-customizer__btn geex-customizer__btn--dark\">
\t\t\t\t\t\t<svg width=\"144\" height=\"86\" viewBox=\"0 0 144 86\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t<rect width=\"144\" height=\"86\" rx=\"10\" fill=\"#2F2A36\"/>
\t\t\t\t\t\t\t<circle cx=\"27\" cy=\"22\" r=\"4\" fill=\"#FF5653\"/>
\t\t\t\t\t\t\t<circle cx=\"38\" cy=\"22\" r=\"4\" fill=\"#FDB23A\"/>
\t\t\t\t\t\t\t<circle cx=\"49\" cy=\"22\" r=\"4\" fill=\"#2CBF44\"/>
\t\t\t\t\t\t\t<rect x=\"22\" y=\"36\" width=\"110\" height=\"1\" fill=\"#D0D6DE\"/>
\t\t\t\t\t\t\t<path d=\"M31.94 58.34H26.38L25.46 61H22.52L27.54 47.02H30.8L35.82 61H32.86L31.94 58.34ZM31.18 56.1L29.16 50.26L27.14 56.1H31.18ZM36.9764 55.42C36.9764 54.3 37.1964 53.3067 37.6364 52.44C38.0897 51.5733 38.6964 50.9067 39.4564 50.44C40.2297 49.9733 41.0897 49.74 42.0364 49.74C42.8631 49.74 43.5831 49.9067 44.1964 50.24C44.8231 50.5733 45.3231 50.9933 45.6964 51.5V49.92H48.5164V61H45.6964V59.38C45.3364 59.9 44.8364 60.3333 44.1964 60.68C43.5697 61.0133 42.8431 61.18 42.0164 61.18C41.0831 61.18 40.2297 60.94 39.4564 60.46C38.6964 59.98 38.0897 59.3067 37.6364 58.44C37.1964 57.56 36.9764 56.5533 36.9764 55.42ZM45.6964 55.46C45.6964 54.78 45.5631 54.2 45.2964 53.72C45.0297 53.2267 44.6697 52.8533 44.2164 52.6C43.7631 52.3333 43.2764 52.2 42.7564 52.2C42.2364 52.2 41.7564 52.3267 41.3164 52.58C40.8764 52.8333 40.5164 53.2067 40.2364 53.7C39.9697 54.18 39.8364 54.7533 39.8364 55.42C39.8364 56.0867 39.9697 56.6733 40.2364 57.18C40.5164 57.6733 40.8764 58.0533 41.3164 58.32C41.7697 58.5867 42.2497 58.72 42.7564 58.72C43.2764 58.72 43.7631 58.5933 44.2164 58.34C44.6697 58.0733 45.0297 57.7 45.2964 57.22C45.5631 56.7267 45.6964 56.14 45.6964 55.46Z\" fill=\"#D0D6DE\"/>
\t\t\t\t\t\t</svg>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t
\t\t\t\t\t</button>
\t\t\t\t</li>
\t\t\t</ul>
\t\t</div>
\t\t<div class=\"geex-customizer__single\">
\t\t\t<h4 class=\"geex-customizer__single__title\">Navbar Type</h4>
\t\t\t<ul class=\"geex-customizer__list geex-customizer__list--navbar\">
\t\t\t\t<li class=\"geex-customizer__list__item\">
\t\t\t\t\t<button class=\"geex-btn geex-customizer__btn geex-customizer__btn--side active\">
\t\t\t\t\t\t<svg width=\"149\" height=\"92\" viewBox=\"0 0 149 92\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t<rect x=\"46\" width=\"103\" height=\"92\" rx=\"10\" fill=\"white\"/>
\t\t\t\t\t\t\t<rect width=\"40\" height=\"92\" rx=\"10\" fill=\"white\"/>
\t\t\t\t\t\t</svg>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t
\t\t\t\t\t</button>
\t\t\t\t</li>
\t\t\t\t<li class=\"geex-customizer__list__item\">
\t\t\t\t\t<button class=\"geex-btn geex-customizer__btn geex-customizer__btn--top\">
\t\t\t\t\t\t<svg width=\"149\" height=\"92\" viewBox=\"0 0 149 92\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t<rect y=\"13\" width=\"149\" height=\"79\" rx=\"10\" fill=\"white\"/>
\t\t\t\t\t\t\t<rect width=\"149\" height=\"8\" rx=\"4\" fill=\"white\"/>
\t\t\t\t\t\t</svg>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t
\t\t\t\t\t</button>
\t\t\t\t</li>
\t\t\t</ul>
\t\t</div>
\t</div>
\t<div class=\"geex-customizer-overlay\"></div>
</div> ";
        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        yield from [];
    }

    /**
     * @codeCoverageIgnore
     */
    public function getTemplateName(): string
    {
        return "partials/customizer.html.twig";
    }

    /**
     * @codeCoverageIgnore
     */
    public function getDebugInfo(): array
    {
        return array (  48 => 1,);
    }

    public function getSourceContext(): Source
    {
        return new Source("<div class=\"geex-customizer\">
\t<div class=\"geex-customizer__header\">
\t\t<h4 class=\"geex-customizer__title\">Customizer</h4>
\t\t<button class=\"geex-btn geex-btn__customizer-close\">
\t\t\t<svg width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t<path d=\"M18 7.05L16.95 6L12 10.95L7.05 6L6 7.05L10.95 12L6 16.95L7.05 18L12 13.05L16.95 18L18 16.95L13.05 12L18 7.05Z\" fill=\"#BCBFDB\"/>
\t\t\t\t<path d=\"M18 7.05L16.95 6L12 10.95L7.05 6L6 7.05L10.95 12L6 16.95L7.05 18L12 13.05L16.95 18L18 16.95L13.05 12L18 7.05Z\" fill=\"black\" fill-opacity=\"0.8\"/>
\t\t\t</svg>
\t\t</button>
\t</div>
\t<div class=\"geex-customizer__body\">
\t\t<div class=\"geex-customizer__single\">
\t\t\t<h5 class=\"geex-customizer__single__title\">Layout Types</h5>
\t\t\t<ul class=\"geex-customizer__list geex-customizer__list--layout\">
\t\t\t\t<li class=\"geex-customizer__list__item\">
\t\t\t\t\t<button class=\"geex-btn geex-customizer__btn geex-customizer__btn--ltr active\">
\t\t\t\t\t\t<svg width=\"24\" height=\"20\" viewBox=\"0 0 24 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t<rect x=\"4.5\" y=\"2.5\" width=\"13\" height=\"5\" rx=\"1.5\" stroke=\"white\"/>
\t\t\t\t\t\t\t<rect x=\"4.5\" y=\"12.5\" width=\"19\" height=\"5\" rx=\"1.5\" stroke=\"white\"/>
\t\t\t\t\t\t\t<rect width=\"1\" height=\"20\" fill=\"white\"/>
\t\t\t\t\t\t</svg>
\t\t\t\t\t\tLTR
\t\t\t\t\t</button>
\t\t\t\t</li>
\t\t\t\t<li class=\"geex-customizer__list__item\">
\t\t\t\t\t<button class=\"geex-btn geex-customizer__btn geex-customizer__btn--rtl\">
\t\t\t\t\t\tRTL
\t\t\t\t\t\t<svg width=\"24\" height=\"20\" viewBox=\"0 0 24 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t<rect x=\"-0.5\" y=\"0.5\" width=\"13\" height=\"5\" rx=\"1.5\" transform=\"matrix(-1 0 0 1 19 2)\" stroke=\"#AB54DB\"/>
\t\t\t\t\t\t\t<rect x=\"-0.5\" y=\"0.5\" width=\"19\" height=\"5\" rx=\"1.5\" transform=\"matrix(-1 0 0 1 19 12)\" stroke=\"#AB54DB\"/>
\t\t\t\t\t\t\t<rect width=\"1\" height=\"20\" transform=\"matrix(-1 0 0 1 24 0)\" fill=\"#AB54DB\"/>
\t\t\t\t\t\t</svg>\t\t\t\t\t\t\t\t\t
\t\t\t\t\t</button>
\t\t\t\t</li>
\t\t\t</ul>
\t\t</div>
\t\t<div class=\"geex-customizer__single\">
\t\t\t<h4 class=\"geex-customizer__single__title\">Mode Type</h4>
\t\t\t<ul class=\"geex-customizer__list geex-customizer__list--sidebar\">
\t\t\t\t<li class=\"geex-customizer__list__item\">
\t\t\t\t\t<button class=\"geex-btn geex-customizer__btn geex-customizer__btn--light active\">
\t\t\t\t\t\t<svg width=\"144\" height=\"86\" viewBox=\"0 0 144 86\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t<rect width=\"144\" height=\"86\" rx=\"10\" fill=\"white\"/>
\t\t\t\t\t\t\t<circle cx=\"27\" cy=\"22\" r=\"4\" fill=\"#FF5653\"/>
\t\t\t\t\t\t\t<circle cx=\"38\" cy=\"22\" r=\"4\" fill=\"#FDB23A\"/>
\t\t\t\t\t\t\t<circle cx=\"49\" cy=\"22\" r=\"4\" fill=\"#2CBF44\"/>
\t\t\t\t\t\t\t<rect x=\"22\" y=\"36\" width=\"110\" height=\"1\" fill=\"#E7E7E7\"/>
\t\t\t\t\t\t\t<path d=\"M31.94 58.34H26.38L25.46 61H22.52L27.54 47.02H30.8L35.82 61H32.86L31.94 58.34ZM31.18 56.1L29.16 50.26L27.14 56.1H31.18ZM36.9764 55.42C36.9764 54.3 37.1964 53.3067 37.6364 52.44C38.0897 51.5733 38.6964 50.9067 39.4564 50.44C40.2297 49.9733 41.0897 49.74 42.0364 49.74C42.8631 49.74 43.5831 49.9067 44.1964 50.24C44.8231 50.5733 45.3231 50.9933 45.6964 51.5V49.92H48.5164V61H45.6964V59.38C45.3364 59.9 44.8364 60.3333 44.1964 60.68C43.5697 61.0133 42.8431 61.18 42.0164 61.18C41.0831 61.18 40.2297 60.94 39.4564 60.46C38.6964 59.98 38.0897 59.3067 37.6364 58.44C37.1964 57.56 36.9764 56.5533 36.9764 55.42ZM45.6964 55.46C45.6964 54.78 45.5631 54.2 45.2964 53.72C45.0297 53.2267 44.6697 52.8533 44.2164 52.6C43.7631 52.3333 43.2764 52.2 42.7564 52.2C42.2364 52.2 41.7564 52.3267 41.3164 52.58C40.8764 52.8333 40.5164 53.2067 40.2364 53.7C39.9697 54.18 39.8364 54.7533 39.8364 55.42C39.8364 56.0867 39.9697 56.6733 40.2364 57.18C40.5164 57.6733 40.8764 58.0533 41.3164 58.32C41.7697 58.5867 42.2497 58.72 42.7564 58.72C43.2764 58.72 43.7631 58.5933 44.2164 58.34C44.6697 58.0733 45.0297 57.7 45.2964 57.22C45.5631 56.7267 45.6964 56.14 45.6964 55.46Z\" fill=\"#464255\"/>
\t\t\t\t\t\t</svg>\t\t\t\t\t\t\t
\t\t\t\t\t</button>
\t\t\t\t</li>
\t\t\t\t<li class=\"geex-customizer__list__item\">
\t\t\t\t\t<button class=\"geex-btn geex-customizer__btn geex-customizer__btn--dark\">
\t\t\t\t\t\t<svg width=\"144\" height=\"86\" viewBox=\"0 0 144 86\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t<rect width=\"144\" height=\"86\" rx=\"10\" fill=\"#2F2A36\"/>
\t\t\t\t\t\t\t<circle cx=\"27\" cy=\"22\" r=\"4\" fill=\"#FF5653\"/>
\t\t\t\t\t\t\t<circle cx=\"38\" cy=\"22\" r=\"4\" fill=\"#FDB23A\"/>
\t\t\t\t\t\t\t<circle cx=\"49\" cy=\"22\" r=\"4\" fill=\"#2CBF44\"/>
\t\t\t\t\t\t\t<rect x=\"22\" y=\"36\" width=\"110\" height=\"1\" fill=\"#D0D6DE\"/>
\t\t\t\t\t\t\t<path d=\"M31.94 58.34H26.38L25.46 61H22.52L27.54 47.02H30.8L35.82 61H32.86L31.94 58.34ZM31.18 56.1L29.16 50.26L27.14 56.1H31.18ZM36.9764 55.42C36.9764 54.3 37.1964 53.3067 37.6364 52.44C38.0897 51.5733 38.6964 50.9067 39.4564 50.44C40.2297 49.9733 41.0897 49.74 42.0364 49.74C42.8631 49.74 43.5831 49.9067 44.1964 50.24C44.8231 50.5733 45.3231 50.9933 45.6964 51.5V49.92H48.5164V61H45.6964V59.38C45.3364 59.9 44.8364 60.3333 44.1964 60.68C43.5697 61.0133 42.8431 61.18 42.0164 61.18C41.0831 61.18 40.2297 60.94 39.4564 60.46C38.6964 59.98 38.0897 59.3067 37.6364 58.44C37.1964 57.56 36.9764 56.5533 36.9764 55.42ZM45.6964 55.46C45.6964 54.78 45.5631 54.2 45.2964 53.72C45.0297 53.2267 44.6697 52.8533 44.2164 52.6C43.7631 52.3333 43.2764 52.2 42.7564 52.2C42.2364 52.2 41.7564 52.3267 41.3164 52.58C40.8764 52.8333 40.5164 53.2067 40.2364 53.7C39.9697 54.18 39.8364 54.7533 39.8364 55.42C39.8364 56.0867 39.9697 56.6733 40.2364 57.18C40.5164 57.6733 40.8764 58.0533 41.3164 58.32C41.7697 58.5867 42.2497 58.72 42.7564 58.72C43.2764 58.72 43.7631 58.5933 44.2164 58.34C44.6697 58.0733 45.0297 57.7 45.2964 57.22C45.5631 56.7267 45.6964 56.14 45.6964 55.46Z\" fill=\"#D0D6DE\"/>
\t\t\t\t\t\t</svg>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t
\t\t\t\t\t</button>
\t\t\t\t</li>
\t\t\t</ul>
\t\t</div>
\t\t<div class=\"geex-customizer__single\">
\t\t\t<h4 class=\"geex-customizer__single__title\">Navbar Type</h4>
\t\t\t<ul class=\"geex-customizer__list geex-customizer__list--navbar\">
\t\t\t\t<li class=\"geex-customizer__list__item\">
\t\t\t\t\t<button class=\"geex-btn geex-customizer__btn geex-customizer__btn--side active\">
\t\t\t\t\t\t<svg width=\"149\" height=\"92\" viewBox=\"0 0 149 92\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t<rect x=\"46\" width=\"103\" height=\"92\" rx=\"10\" fill=\"white\"/>
\t\t\t\t\t\t\t<rect width=\"40\" height=\"92\" rx=\"10\" fill=\"white\"/>
\t\t\t\t\t\t</svg>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t
\t\t\t\t\t</button>
\t\t\t\t</li>
\t\t\t\t<li class=\"geex-customizer__list__item\">
\t\t\t\t\t<button class=\"geex-btn geex-customizer__btn geex-customizer__btn--top\">
\t\t\t\t\t\t<svg width=\"149\" height=\"92\" viewBox=\"0 0 149 92\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">
\t\t\t\t\t\t\t<rect y=\"13\" width=\"149\" height=\"79\" rx=\"10\" fill=\"white\"/>
\t\t\t\t\t\t\t<rect width=\"149\" height=\"8\" rx=\"4\" fill=\"white\"/>
\t\t\t\t\t\t</svg>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t
\t\t\t\t\t</button>
\t\t\t\t</li>
\t\t\t</ul>
\t\t</div>
\t</div>
\t<div class=\"geex-customizer-overlay\"></div>
</div> ", "partials/customizer.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\partials\\customizer.html.twig");
    }
}
