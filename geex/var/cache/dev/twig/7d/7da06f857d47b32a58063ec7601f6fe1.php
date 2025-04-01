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

/* pages/landingPage.html.twig */
class __TwigTemplate_46464a41294f447bb7819373eff34187 extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/landingPage.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "pages/landingPage.html.twig"));

        // line 1
        yield "<!doctype html>
<html lang=\"en\" dir=\"ltr\">

<head>
\t<meta charset=\"UTF-8\">
\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">
\t<title>Blank - Geex Dashboard</title>

\t<link href=\"https://fonts.googleapis.com/css2?family=Jost:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">

\t<!-- inject:css-->
\t<link rel=\"stylesheet\" href=\"./assets/vendor/css/bootstrap/bootstrap.css\">
\t<link rel=\"stylesheet\" href=\"assets/css/style.css\">
\t<!-- endinject -->
\t<link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"assets/img/favicon.svg\">
\t<!-- Fonts -->
\t<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/@iconscout/unicons@4.0.8/css/line.min.css\">

    <link rel=\"stylesheet\" href=\"./eventtalk/css/open-iconic-bootstrap.min.css\">
    <link rel=\"stylesheet\" href=\"./eventtalk/css/animate.css\">

    <link rel=\"stylesheet\" href=\"./eventtalk/css/owl.carousel.min.css\">
    <link rel=\"stylesheet\" href=\"./eventtalk/css/owl.theme.default.min.css\">
    <link rel=\"stylesheet\" href=\"./eventtalk/css/magnific-popup.css\">

    <link rel=\"stylesheet\" href=\"./eventtalk/css/aos.css\">

    <link rel=\"stylesheet\" href=\"./eventtalk/css/ionicons.min.css\">

    <link rel=\"stylesheet\" href=\"./eventtalk/css/bootstrap-datepicker.css\">
    <link rel=\"stylesheet\" href=\"./eventtalk/css/jquery.timepicker.css\">


    <link rel=\"stylesheet\" href=\"./eventtalk/css/flaticon.css\">
    <link rel=\"stylesheet\" href=\"./eventtalk/css/icomoon.css\">
    <link rel=\"stylesheet\" href=\"./eventtalk/css/style.css\">
    <script>
\t\t// Render localStorage JS:
\t\tif (localStorage.theme) document.documentElement.setAttribute(\"data-theme\", localStorage.theme);
\t\tif (localStorage.layout) document.documentElement.setAttribute(\"data-nav\", localStorage.navbar);
\t\tif (localStorage.layout) document.documentElement.setAttribute(\"dir\", localStorage.layout);
    </script>
</head>

<body class=\"geex-dashboard\">

    ";
        // line 48
        yield from $this->loadTemplate("./partials/header.html.twig", "pages/landingPage.html.twig", 48)->unwrap()->yield($context);
        // line 49
        yield "


    <main class=\"geex-main-content\">


        ";
        // line 55
        yield from $this->loadTemplate("./partials/sidebar.html.twig", "pages/landingPage.html.twig", 55)->unwrap()->yield($context);
        // line 56
        yield "

        ";
        // line 58
        yield from $this->loadTemplate("./partials/customizer.html.twig", "pages/landingPage.html.twig", 58)->unwrap()->yield($context);
        // line 59
        yield "
\t\t<div class=\"geex-content\">
\t\t\t<div class=\"geex-content__section geex-content__blank\">
                   <div class=\"hero-wrap js-fullheight\" style=\"background-image: url('./eventtalk/images/bg_1.jpg');\" data-stellar-background-ratio=\"0.5\">

                      <div class=\"container\">
                        <div class=\"row no-gutters slider-text js-fullheight align-items-center justify-content-start\" data-scrollax-parent=\"true\">
                          <div class=\"col-xl-10 ftco-animate\" data-scrollax=\" properties: { translateY: '70%' }\">
                            <h1 class=\"mb-4\" data-scrollax=\"properties: { translateY: '30%', opacity: 1.6 }\"> Developer <br><span>Conference 2019</span></h1>
                            <p class=\"mb-4\" data-scrollax=\"properties: { translateY: '30%', opacity: 1.6 }\">December 21-24, 2019. Paris, Italy</p>
                            <div id=\"timer\" class=\"d-flex mb-3\">
                \t\t\t\t\t\t  <div class=\"time\" id=\"days\"></div>
                \t\t\t\t\t\t  <div class=\"time pl-4\" id=\"hours\"></div>
                \t\t\t\t\t\t  <div class=\"time pl-4\" id=\"minutes\"></div>
                \t\t\t\t\t\t  <div class=\"time pl-4\" id=\"seconds\"></div>
                \t\t\t\t\t\t</div>
                          </div>
                        </div>
                      </div>
                    </div>

                    <section class=\"ftco-section services-section bg-light\">
                      <div class=\"container\">
                        <div class=\"row d-flex\">
                          <div class=\"col-md-3 d-flex align-self-stretch ftco-animate\">
                            <div class=\"media block-6 services d-block\">
                              <div class=\"icon\"><span class=\"flaticon-placeholder\"></span></div>
                              <div class=\"media-body\">
                                <h3 class=\"heading mb-3\">Venue</h3>
                                <p>\t203 Fake St. Mountain View, San Francisco, California, USA</p>
                              </div>
                            </div>
                          </div>
                          <div class=\"col-md-3 d-flex align-self-stretch ftco-animate\">
                            <div class=\"media block-6 services d-block\">
                              <div class=\"icon\"><span class=\"flaticon-world\"></span></div>
                              <div class=\"media-body\">
                                <h3 class=\"heading mb-3\">Transport</h3>
                                <p>A small river named Duden flows by their place and supplies.</p>
                              </div>
                            </div>
                          </div>
                          <div class=\"col-md-3 d-flex align-self-stretch ftco-animate\">
                            <div class=\"media block-6 services d-block\">
                              <div class=\"icon\"><span class=\"flaticon-hotel\"></span></div>
                              <div class=\"media-body\">
                                <h3 class=\"heading mb-3\">Hotel</h3>
                                <p>A small river named Duden flows by their place and supplies.</p>
                              </div>
                            </div>
                          </div>
                          <div class=\"col-md-3 d-flex align-self-stretch ftco-animate\">
                            <div class=\"media block-6 services d-block\">
                              <div class=\"icon\"><span class=\"flaticon-cooking\"></span></div>
                              <div class=\"media-body\">
                                <h3 class=\"heading mb-3\">Restaurant</h3>
                                <p>A small river named Duden flows by their place and supplies.</p>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </section>

                    <section class=\"ftco-counter img\" id=\"section-counter\">
                    \t<div class=\"container\">
                    \t\t<div class=\"row d-flex\">
                    \t\t\t<div class=\"col-md-6 d-flex\">
                    \t\t\t\t<div class=\"img d-flex align-self-stretch\" style=\"background-image:url(./eventtalk/images/about.jpg);\"></div>
                    \t\t\t</div>
                    \t\t\t<div class=\"col-md-6 pl-md-5 py-5\">
                    \t\t\t\t<div class=\"row justify-content-start pb-3\">
                \t\t          <div class=\"col-md-12 heading-section ftco-animate\">
                \t\t          \t<span class=\"subheading\">Fun Facts</span>
                \t\t            <h2 class=\"mb-4\"><span>Fun</span> Facts</h2>
                \t\t            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>
                \t\t          </div>
                \t\t        </div>
                \t\t    \t\t<div class=\"row\">
                \t\t          <div class=\"col-md-6 justify-content-center counter-wrap ftco-animate\">
                \t\t            <div class=\"block-18 text-center py-4 bg-light mb-4\">
                \t\t              <div class=\"text\">
                \t\t              \t<div class=\"icon d-flex justify-content-center align-items-center\">
                \t\t              \t\t<span class=\"flaticon-guest\"></span>
                \t\t              \t</div>
                \t\t                <strong class=\"number\" data-number=\"30\">0</strong>
                \t\t                <span>Speakers</span>
                \t\t              </div>
                \t\t            </div>
                \t\t          </div>
                \t\t          <div class=\"col-md-6 justify-content-center counter-wrap ftco-animate\">
                \t\t            <div class=\"block-18 text-center py-4 bg-light mb-4\">
                \t\t              <div class=\"text\">
                \t\t              \t<div class=\"icon d-flex justify-content-center align-items-center\">
                \t\t              \t\t<span class=\"flaticon-handshake\"></span>
                \t\t              \t</div>
                \t\t                <strong class=\"number\" data-number=\"200\">0</strong>
                \t\t                <span>Sponsor</span>
                \t\t              </div>
                \t\t            </div>
                \t\t          </div>
                \t\t          <div class=\"col-md-6 justify-content-center counter-wrap ftco-animate\">
                \t\t            <div class=\"block-18 text-center py-4 bg-light mb-4\">
                \t\t              <div class=\"text\">
                \t\t              \t<div class=\"icon d-flex justify-content-center align-items-center\">
                \t\t              \t\t<span class=\"flaticon-chair\"></span>
                \t\t              \t</div>
                \t\t                <strong class=\"number\" data-number=\"2500\">0</strong>
                \t\t                <span>Total Seats</span>
                \t\t              </div>
                \t\t            </div>
                \t\t          </div>
                \t\t          <div class=\"col-md-6 justify-content-center counter-wrap ftco-animate\">
                \t\t            <div class=\"block-18 text-center py-4 bg-light mb-4\">
                \t\t              <div class=\"text\">
                \t\t              \t<div class=\"icon d-flex justify-content-center align-items-center\">
                \t\t              \t\t<span class=\"flaticon-idea\"></span>
                \t\t              \t</div>
                \t\t                <strong class=\"number\" data-number=\"40\">0</strong>
                \t\t                <span>Topics</span>
                \t\t              </div>
                \t\t            </div>
                \t\t          </div>
                \t\t        </div>
                \t        </div>
                        </div>
                    \t</div>
                    </section>

                    <section class=\"ftco-section\">
                    \t<div class=\"container\">
                    \t\t<div class=\"row justify-content-center mb-5 pb-3\">
                          <div class=\"col-md-7 text-center heading-section ftco-animate\">
                          \t<span class=\"subheading\">Speaker</span>
                            <h2 class=\"mb-4\"><span>Our</span> Speakers</h2>
                          </div>
                        </div>
                        <div class=\"row\">
                        \t<div class=\"col-md-12 ftco-animate\">
                        \t\t<div class=\"carousel-testimony owl-carousel\">
                        \t\t\t<div class=\"item\">
                        \t\t\t\t<div class=\"speaker\">
                \t\t\t        \t\t<img src=\"./eventtalk/images/speaker-1.jpg\" class=\"img-fluid\" alt=\"Colorlib HTML5 Template\">
                \t\t\t        \t\t<div class=\"text text-center py-3\">
                \t\t\t        \t\t\t<h3>John Adams</h3>
                \t\t\t        \t\t\t<span class=\"position\">Web Developer</span>
                \t\t\t        \t\t\t<ul class=\"ftco-social mt-3\">
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>
                \t\t\t              </ul>
                \t\t\t        \t\t</div>
                \t\t\t        \t</div>
                        \t\t\t</div>

                        \t\t\t<div class=\"item\">
                        \t\t\t\t<div class=\"speaker\">
                \t\t\t        \t\t<img src=\"./eventtalk/images/speaker-2.jpg\" class=\"img-fluid\" alt=\"Colorlib HTML5 Template\">
                \t\t\t        \t\t<div class=\"text text-center py-3\">
                \t\t\t        \t\t\t<h3>Paul George</h3>
                \t\t\t        \t\t\t<span class=\"position\">Web Developer</span>
                \t\t\t        \t\t\t<ul class=\"ftco-social mt-3\">
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>
                \t\t\t              </ul>
                \t\t\t        \t\t</div>
                \t\t\t        \t</div>
                        \t\t\t</div>

                        \t\t\t<div class=\"item\">
                        \t\t\t\t<div class=\"speaker\">
                \t\t\t        \t\t<img src=\"./eventtalk/images/speaker-3.jpg\" class=\"img-fluid\" alt=\"Colorlib HTML5 Template\">
                \t\t\t        \t\t<div class=\"text text-center py-3\">
                \t\t\t        \t\t\t<h3>James Smith</h3>
                \t\t\t        \t\t\t<span class=\"position\">Web Developer</span>
                \t\t\t        \t\t\t<ul class=\"ftco-social mt-3\">
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>
                \t\t\t              </ul>
                \t\t\t        \t\t</div>
                \t\t\t        \t</div>
                        \t\t\t</div>

                        \t\t\t<div class=\"item\">
                        \t\t\t\t<div class=\"speaker\">
                \t\t\t        \t\t<img src=\"./eventtalk/images/speaker-4.jpg\" class=\"img-fluid\" alt=\"Colorlib HTML5 Template\">
                \t\t\t        \t\t<div class=\"text text-center py-3\">
                \t\t\t        \t\t\t<h3>Angelie Crawford</h3>
                \t\t\t        \t\t\t<span class=\"position\">Web Developer</span>
                \t\t\t        \t\t\t<ul class=\"ftco-social mt-3\">
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>
                \t\t\t              </ul>
                \t\t\t        \t\t</div>
                \t\t\t        \t</div>
                        \t\t\t</div>

                        \t\t\t<div class=\"item\">
                        \t\t\t\t<div class=\"speaker\">
                \t\t\t        \t\t<img src=\"./eventtalk/images/speaker-5.jpg\" class=\"img-fluid\" alt=\"Colorlib HTML5 Template\">
                \t\t\t        \t\t<div class=\"text text-center py-3\">
                \t\t\t        \t\t\t<h3>Jackie Spears</h3>
                \t\t\t        \t\t\t<span class=\"position\">Entrepreneur</span>
                \t\t\t        \t\t\t<ul class=\"ftco-social mt-3\">
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>
                \t\t\t              </ul>
                \t\t\t        \t\t</div>
                \t\t\t        \t</div>
                        \t\t\t</div>
                        \t\t</div>
                        \t</div>
                        </div>
                    \t</div>
                    </section>


                \t\t<section class=\"ftco-section bg-light\">
                \t\t\t<div class=\"container\">
                \t\t\t\t<div class=\"row justify-content-center mb-5 pb-3\">
                          <div class=\"col-md-7 text-center heading-section ftco-animate\">
                          \t<span class=\"subheading\">Schedule</span>
                            <h2 class=\"mb-4\"><span>Event</span> Schedule</h2>
                          </div>
                        </div>
                        <div class=\"ftco-search\">
                \t\t\t\t\t<div class=\"row\">
                            <div class=\"col-md-12 nav-link-wrap\">
                \t            <div class=\"nav nav-pills d-flex text-center\" id=\"v-pills-tab\" role=\"tablist\" aria-orientation=\"vertical\">
                \t              <a class=\"nav-link ftco-animate active\" id=\"v-pills-1-tab\" data-toggle=\"pill\" href=\"#v-pills-1\" role=\"tab\" aria-controls=\"v-pills-1\" aria-selected=\"true\">Day 01 <span>21 Dec. 2019</span></a>

                \t              <a class=\"nav-link ftco-animate\" id=\"v-pills-2-tab\" data-toggle=\"pill\" href=\"#v-pills-2\" role=\"tab\" aria-controls=\"v-pills-2\" aria-selected=\"false\">Day 02 <span>22 Dec. 2019</span></a>

                \t              <a class=\"nav-link ftco-animate\" id=\"v-pills-3-tab\" data-toggle=\"pill\" href=\"#v-pills-3\" role=\"tab\" aria-controls=\"v-pills-3\" aria-selected=\"false\">Day 03 <span>23 Dec. 2019</span></a>

                \t              <a class=\"nav-link ftco-animate\" id=\"v-pills-4-tab\" data-toggle=\"pill\" href=\"#v-pills-4\" role=\"tab\" aria-controls=\"v-pills-4\" aria-selected=\"false\">Day 04 <span>24 Dec. 2019</span></a>

                \t            </div>
                \t          </div>
                \t          <div class=\"col-md-12 tab-wrap\">

                \t            <div class=\"tab-content\" id=\"v-pills-tabContent\">

                \t              <div class=\"tab-pane fade show active\" id=\"v-pills-1\" role=\"tabpanel\" aria-labelledby=\"day-1-tab\">
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_1.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Introduction to Wordpress 5.0</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_2.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Best Practices For Programming WordPress</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_3.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Web Performance For Third Party Scripts</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              </div>

                \t              <div class=\"tab-pane fade\" id=\"v-pills-2\" role=\"tabpanel\" aria-labelledby=\"v-pills-day-2-tab\">
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_1.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Introduction to Wordpress 5.0</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_2.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Best Practices For Programming WordPress</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_3.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Web Performance For Third Party Scripts</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              </div>
                \t              <div class=\"tab-pane fade\" id=\"v-pills-3\" role=\"tabpanel\" aria-labelledby=\"v-pills-day-3-tab\">
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_1.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Introduction to Wordpress 5.0</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_2.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Best Practices For Programming WordPress</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_3.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Web Performance For Third Party Scripts</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              </div>
                \t              <div class=\"tab-pane fade\" id=\"v-pills-4\" role=\"tabpanel\" aria-labelledby=\"v-pills-day-4-tab\">
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_1.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Introduction to Wordpress 5.0</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_2.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Best Practices For Programming WordPress</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_3.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Web Performance For Third Party Scripts</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              </div>
                \t            </div>
                \t          </div>
                \t        </div>
                        </div>
                \t\t\t</div>
                \t\t</section>


                    <section class=\"ftco-section testimony-section\">
                      <div class=\"container\">
                        <div class=\"row justify-content-center mb-5 pb-3\">
                          <div class=\"col-md-7 text-center heading-section ftco-animate\">
                          \t<span class=\"subheading\">Testimonial</span>
                            <h2 class=\"mb-4\"><span>Happy</span> Clients</h2>
                          </div>
                        </div>
                        <div class=\"row ftco-animate\">
                          <div class=\"col-md-12\">
                            <div class=\"carousel-testimony owl-carousel ftco-owl\">
                              <div class=\"item\">
                                <div class=\"testimony-wrap text-center py-4 pb-5\">
                                  <div class=\"user-img mb-4\" style=\"background-image: url(./eventtalk/images/person_1.jpg)\">
                                    <span class=\"quote d-flex align-items-center justify-content-center\">
                                      <i class=\"icon-quote-left\"></i>
                                    </span>
                                  </div>
                                  <div class=\"text\">
                                    <p class=\"mb-4\">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                    <p class=\"name\">Roger Scott</p>
                                    <span class=\"position\">Marketing Manager</span>
                                  </div>
                                </div>
                              </div>
                              <div class=\"item\">
                                <div class=\"testimony-wrap text-center py-4 pb-5\">
                                  <div class=\"user-img mb-4\" style=\"background-image: url(./eventtalk/images/person_2.jpg)\">
                                    <span class=\"quote d-flex align-items-center justify-content-center\">
                                      <i class=\"icon-quote-left\"></i>
                                    </span>
                                  </div>
                                  <div class=\"text\">
                                    <p class=\"mb-4\">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                    <p class=\"name\">Roger Scott</p>
                                    <span class=\"position\">Interface Designer</span>
                                  </div>
                                </div>
                              </div>
                              <div class=\"item\">
                                <div class=\"testimony-wrap text-center py-4 pb-5\">
                                  <div class=\"user-img mb-4\" style=\"background-image: url(./eventtalk/images/person_3.jpg)\">
                                    <span class=\"quote d-flex align-items-center justify-content-center\">
                                      <i class=\"icon-quote-left\"></i>
                                    </span>
                                  </div>
                                  <div class=\"text\">
                                    <p class=\"mb-4\">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                    <p class=\"name\">Roger Scott</p>
                                    <span class=\"position\">UI Designer</span>
                                  </div>
                                </div>
                              </div>
                              <div class=\"item\">
                                <div class=\"testimony-wrap text-center py-4 pb-5\">
                                  <div class=\"user-img mb-4\" style=\"background-image: url(./eventtalk/images/person_1.jpg)\">
                                    <span class=\"quote d-flex align-items-center justify-content-center\">
                                      <i class=\"icon-quote-left\"></i>
                                    </span>
                                  </div>
                                  <div class=\"text\">
                                    <p class=\"mb-4\">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                    <p class=\"name\">Roger Scott</p>
                                    <span class=\"position\">Web Developer</span>
                                  </div>
                                </div>
                              </div>
                              <div class=\"item\">
                                <div class=\"testimony-wrap text-center py-4 pb-5\">
                                  <div class=\"user-img mb-4\" style=\"background-image: url(./eventtalk/images/person_1.jpg)\">
                                    <span class=\"quote d-flex align-items-center justify-content-center\">
                                      <i class=\"icon-quote-left\"></i>
                                    </span>
                                  </div>
                                  <div class=\"text\">
                                    <p class=\"mb-4\">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                    <p class=\"name\">Roger Scott</p>
                                    <span class=\"position\">System Analyst</span>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </section>

                    <section class=\"ftco-section bg-light\">
                      <div class=\"container\">
                        <div class=\"row justify-content-center mb-5 pb-3\">
                          <div class=\"col-md-7 heading-section ftco-animate text-center\">
                            <span class=\"subheading\">Pricing Tables</span>
                            <h2 class=\"mb-1\"><span>Our</span> Ticket Pricing</h2>
                          </div>
                        </div>
                        <div class=\"row\">
                \t        <div class=\"col-md-4 ftco-animate\">
                \t          <div class=\"block-7\">
                \t            <div class=\"text-center\">
                \t            <h2 class=\"heading\">Personal</h2>
                \t            <span class=\"price\"><sup>\$</sup> <span class=\"number\">85</span></span>
                \t            <span class=\"excerpt d-block\">per Month</span>

                \t            <h3 class=\"heading-2 my-4\">Enjoy All The Features</h3>

                \t            <ul class=\"pricing-text mb-5\">
                \t              <li>Conference Seats</li>
                \t              <li>Free Wifi</li>
                \t              <li>Coffee Breaks</li>
                \t              <li>Lunch</li>
                \t              <li>Workshops</li>
                \t              <li>One Speakers</li>
                \t              <li>Papers</li>
                \t            </ul>

                \t            <a href=\"#\" class=\"btn btn-primary d-block px-2 py-3\">Buy Ticket</a>
                \t            </div>
                \t          </div>
                \t        </div>
                \t        <div class=\"col-md-4 ftco-animate\">
                \t          <div class=\"block-7\">
                \t            <div class=\"text-center\">
                \t            <h2 class=\"heading\">Small Team</h2>
                \t            <span class=\"price\"><sup>\$</sup> <span class=\"number\">200</span></span>
                \t            <span class=\"excerpt d-block\">per Month</span>

                \t            <h3 class=\"heading-2 my-4\">Enjoy All The Features</h3>

                \t            <ul class=\"pricing-text mb-5\">
                \t              <li>Conference Seats</li>
                \t              <li>Free Wifi</li>
                \t              <li>Coffee Breaks</li>
                \t              <li>Lunch</li>
                \t              <li>Workshops</li>
                \t              <li>One Speakers</li>
                \t              <li>Papers</li>
                \t            </ul>

                \t            <a href=\"#\" class=\"btn btn-primary d-block px-2 py-3\">Buy Ticket</a>
                \t            </div>
                \t          </div>
                \t        </div>
                \t        <div class=\"col-md-4 ftco-animate\">
                \t          <div class=\"block-7\">
                \t            <div class=\"text-center\">
                \t            <h2 class=\"heading\">Family Pack</h2>
                \t            <span class=\"price\"><sup>\$</sup> <span class=\"number\">499</span></span>
                \t            <span class=\"excerpt d-block\">per Month</span>

                \t            <h3 class=\"heading-2 my-4\">Enjoy All The Features</h3>

                \t            <ul class=\"pricing-text mb-5\">
                \t              <li>Conference Seats</li>
                \t              <li>Free Wifi</li>
                \t              <li>Coffee Breaks</li>
                \t              <li>Lunch</li>
                \t              <li>Workshops</li>
                \t              <li>One Speakers</li>
                \t              <li>Papers</li>
                \t            </ul>

                \t            <a href=\"#\" class=\"btn btn-primary d-block px-2 py-3\">Buy Ticket</a>
                \t            </div>
                \t          </div>
                \t        </div>
                \t      </div>
                      </div>
                    </section>

                    <section class=\"ftco-section bg-light\">
                      <div class=\"container\">
                        <div class=\"row justify-content-center mb-5 pb-3\">
                          <div class=\"col-md-7 heading-section text-center ftco-animate\">
                          \t<span class=\"subheading\">Our Blog</span>
                            <h2><span>Recent</span> Blog</h2>
                          </div>
                        </div>
                        <div class=\"row d-flex\">
                          <div class=\"col-md-4 d-flex ftco-animate\">
                          \t<div class=\"blog-entry justify-content-end\">
                              <a href=\"blog-single.html\" class=\"block-20\" style=\"background-image: url('./eventtalk/images/image_1.jpg');\">
                              </a>
                              <div class=\"text p-4 float-right d-block\">
                              \t<div class=\"d-flex align-items-center pt-2 mb-4\">
                              \t\t<div class=\"one\">
                              \t\t\t<span class=\"day\">07</span>
                              \t\t</div>
                              \t\t<div class=\"two\">
                              \t\t\t<span class=\"yr\">2019</span>
                              \t\t\t<span class=\"mos\">January</span>
                              \t\t</div>
                              \t</div>
                                <h3 class=\"heading mt-2\"><a href=\"#\">Why Lead Generation is Key for Business Growth</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                              </div>
                            </div>
                          </div>
                          <div class=\"col-md-4 d-flex ftco-animate\">
                          \t<div class=\"blog-entry justify-content-end\">
                              <a href=\"blog-single.html\" class=\"block-20\" style=\"background-image: url('./eventtalk/images/image_2.jpg');\">
                              </a>
                              <div class=\"text p-4 float-right d-block\">
                              \t<div class=\"d-flex align-items-center pt-2 mb-4\">
                              \t\t<div class=\"one\">
                              \t\t\t<span class=\"day\">07</span>
                              \t\t</div>
                              \t\t<div class=\"two\">
                              \t\t\t<span class=\"yr\">2019</span>
                              \t\t\t<span class=\"mos\">January</span>
                              \t\t</div>
                              \t</div>
                                <h3 class=\"heading mt-2\"><a href=\"#\">Why Lead Generation is Key for Business Growth</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                              </div>
                            </div>
                          </div>
                          <div class=\"col-md-4 d-flex ftco-animate\">
                          \t<div class=\"blog-entry\">
                              <a href=\"blog-single.html\" class=\"block-20\" style=\"background-image: url('./eventtalk/images/image_3.jpg');\">
                              </a>
                              <div class=\"text p-4 float-right d-block\">
                              \t<div class=\"d-flex align-items-center pt-2 mb-4\">
                              \t\t<div class=\"one\">
                              \t\t\t<span class=\"day\">06</span>
                              \t\t</div>
                              \t\t<div class=\"two\">
                              \t\t\t<span class=\"yr\">2019</span>
                              \t\t\t<span class=\"mos\">January</span>
                              \t\t</div>
                              \t</div>
                                <h3 class=\"heading mt-2\"><a href=\"#\">Why Lead Generation is Key for Business Growth</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </section>

                \t\t<section class=\"ftco-section-parallax\">
                      <div class=\"parallax-img d-flex align-items-center\">
                        <div class=\"container\">
                          <div class=\"row d-flex justify-content-center\">
                            <div class=\"col-md-7 text-center heading-section heading-section-white ftco-animate\">
                              <h2>Subcribe to our Newsletter</h2>
                              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in</p>
                              <div class=\"row d-flex justify-content-center mt-4 mb-4\">
                                <div class=\"col-md-8\">
                                  <form action=\"#\" class=\"subscribe-form\">
                                    <div class=\"form-group d-flex\">
                                      <input type=\"text\" class=\"form-control\" placeholder=\"Enter email address\">
                                      <input type=\"submit\" value=\"Subscribe\" class=\"submit px-3\">
                                    </div>
                                  </form>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </section>

                    <section class=\"ftco-gallery\">
                    \t<div class=\"container-wrap\">
                    \t\t<div class=\"row no-gutters\">
                \t\t\t\t\t<div class=\"col-md-3 ftco-animate\">
                \t\t\t\t\t\t<a href=\"./eventtalk/images/image_1.jpg\" class=\"gallery image-popup img d-flex align-items-center\" style=\"background-image: url(./eventtalk/images/image_1.jpg);\">
                \t\t\t\t\t\t\t<div class=\"icon mb-4 d-flex align-items-center justify-content-center\">
                    \t\t\t\t\t\t<span class=\"icon-instagram\"></span>
                    \t\t\t\t\t</div>
                \t\t\t\t\t\t</a>
                \t\t\t\t\t</div>
                \t\t\t\t\t<div class=\"col-md-3 ftco-animate\">
                \t\t\t\t\t\t<a href=\"./eventtalk/images/image_2.jpg\" class=\"gallery image-popup img d-flex align-items-center\" style=\"background-image: url(./eventtalk/images/image_2.jpg);\">
                \t\t\t\t\t\t\t<div class=\"icon mb-4 d-flex align-items-center justify-content-center\">
                    \t\t\t\t\t\t<span class=\"icon-instagram\"></span>
                    \t\t\t\t\t</div>
                \t\t\t\t\t\t</a>
                \t\t\t\t\t</div>
                \t\t\t\t\t<div class=\"col-md-3 ftco-animate\">
                \t\t\t\t\t\t<a href=\"./eventtalk/images/image_3.jpg\" class=\"gallery image-popup img d-flex align-items-center\" style=\"background-image: url(./eventtalk/images/image_3.jpg);\">
                \t\t\t\t\t\t\t<div class=\"icon mb-4 d-flex align-items-center justify-content-center\">
                    \t\t\t\t\t\t<span class=\"icon-instagram\"></span>
                    \t\t\t\t\t</div>
                \t\t\t\t\t\t</a>
                \t\t\t\t\t</div>
                \t\t\t\t\t<div class=\"col-md-3 ftco-animate\">
                \t\t\t\t\t\t<a href=\"./eventtalk/images/image_4.jpg\" class=\"gallery image-popup img d-flex align-items-center\" style=\"background-image: url(./eventtalk/images/image_4.jpg);\">
                \t\t\t\t\t\t\t<div class=\"icon mb-4 d-flex align-items-center justify-content-center\">
                    \t\t\t\t\t\t<span class=\"icon-instagram\"></span>
                    \t\t\t\t\t</div>
                \t\t\t\t\t\t</a>
                \t\t\t\t\t</div>
                        </div>
                    \t</div>
                    </section>

                    <footer class=\"ftco-footer ftco-bg-dark ftco-section\">
                      <div class=\"container\">
                        <div class=\"row mb-5\">
                          <div class=\"col-md\">
                            <div class=\"ftco-footer-widget mb-4\">
                              <h2 class=\"ftco-heading-2\">Eventalk</h2>
                              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                              <ul class=\"ftco-footer-social list-unstyled float-md-left float-lft mt-5\">
                                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>
                                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>
                                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>
                              </ul>
                            </div>
                          </div>
                          <div class=\"col-md\">
                            <div class=\"ftco-footer-widget mb-4 ml-md-5\">
                              <h2 class=\"ftco-heading-2\">Useful Links</h2>
                              <ul class=\"list-unstyled\">
                                <li><a href=\"#\" class=\"py-2 d-block\">Speakers</a></li>
                                <li><a href=\"#\" class=\"py-2 d-block\">Shcedule</a></li>
                                <li><a href=\"#\" class=\"py-2 d-block\">Events</a></li>
                                <li><a href=\"#\" class=\"py-2 d-block\">Blog</a></li>
                              </ul>
                            </div>
                          </div>
                          <div class=\"col-md\">
                             <div class=\"ftco-footer-widget mb-4\">
                              <h2 class=\"ftco-heading-2\">Privacy</h2>
                              <ul class=\"list-unstyled\">
                                <li><a href=\"#\" class=\"py-2 d-block\">Career</a></li>
                                <li><a href=\"#\" class=\"py-2 d-block\">About Us</a></li>
                                <li><a href=\"#\" class=\"py-2 d-block\">Contact Us</a></li>
                                <li><a href=\"#\" class=\"py-2 d-block\">Services</a></li>
                              </ul>
                            </div>
                          </div>
                          <div class=\"col-md\">
                            <div class=\"ftco-footer-widget mb-4\">
                            \t<h2 class=\"ftco-heading-2\">Have a Questions?</h2>
                            \t<div class=\"block-23 mb-3\">
                \t              <ul>
                \t                <li><span class=\"icon icon-map-marker\"></span><span class=\"text\">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
                \t                <li><a href=\"#\"><span class=\"icon icon-phone\"></span><span class=\"text\">+2 392 3929 210</span></a></li>
                \t                <li><a href=\"#\"><span class=\"icon icon-envelope\"></span><span class=\"text\">info@yourdomain.com</span></a></li>
                \t              </ul>
                \t            </div>
                            </div>
                          </div>
                        </div>
                        <div class=\"row\">
                          <div class=\"col-md-12 text-center\">

                            <p> Ce site est fait avec <i class=\"icon-heart color-danger\" aria-hidden=\"true\"></i> par Quartet!  </p>
                          </div>
                        </div>
                      </div>
                    </footer>

\t\t\t\t<div class=\"geex-content__error__wrapper\">
\t\t\t\t\t<div class=\"geex-content__error__content\">

\t\t\t\t\t</div><!-- .page-content -->
\t\t\t\t</div>
\t\t\t</div>
\t\t</div>
\t</main>
<script src=\"./eventtalk/js/jquery.min.js\"></script>
  <script src=\"./eventtalk/js/jquery-migrate-3.0.1.min.js\"></script>
  <script src=\"./eventtalk/js/popper.min.js\"></script>
  <script src=\"./eventtalk/js/bootstrap.min.js\"></script>
  <script src=\"./eventtalk/js/jquery.easing.1.3.js\"></script>
  <script src=\"./eventtalk/js/jquery.waypoints.min.js\"></script>
  <script src=\"./eventtalk/js/jquery.stellar.min.js\"></script>
  <script src=\"./eventtalk/js/owl.carousel.min.js\"></script>
  <script src=\"./eventtalk/js/jquery.magnific-popup.min.js\"></script>
  <script src=\"./eventtalk/js/aos.js\"></script>
  <script src=\"./eventtalk/js/jquery.animateNumber.min.js\"></script>
  <script src=\"./eventtalk/js/bootstrap-datepicker.js\"></script>
  <script src=\"./eventtalk/js/jquery.timepicker.min.js\"></script>
  <script src=\"./eventtalk/js/scrollax.min.js\"></script>
  <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false\"></script>
  <script src=\"./eventtalk/js/google-map.js\"></script>
  <script src=\"./eventtalk/js/main.js\"></script>

\t<!-- inject:js-->
\t<script src=\"./assets/vendor/js/jquery/jquery-3.5.1.min.js\"></script>
\t<script src=\"./assets/vendor/js/jquery/jquery-ui.js\"></script>
\t<script src=\"./assets/vendor/js/bootstrap/bootstrap.min.js\"></script>
\t<script src=\"./assets/js/main.js\"></script>
\t<!-- endinject-->
</body>

</html>";
        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        yield from [];
    }

    /**
     * @codeCoverageIgnore
     */
    public function getTemplateName(): string
    {
        return "pages/landingPage.html.twig";
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
        return array (  115 => 59,  113 => 58,  109 => 56,  107 => 55,  99 => 49,  97 => 48,  48 => 1,);
    }

    public function getSourceContext(): Source
    {
        return new Source("<!doctype html>
<html lang=\"en\" dir=\"ltr\">

<head>
\t<meta charset=\"UTF-8\">
\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">
\t<title>Blank - Geex Dashboard</title>

\t<link href=\"https://fonts.googleapis.com/css2?family=Jost:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">

\t<!-- inject:css-->
\t<link rel=\"stylesheet\" href=\"./assets/vendor/css/bootstrap/bootstrap.css\">
\t<link rel=\"stylesheet\" href=\"assets/css/style.css\">
\t<!-- endinject -->
\t<link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"assets/img/favicon.svg\">
\t<!-- Fonts -->
\t<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/@iconscout/unicons@4.0.8/css/line.min.css\">

    <link rel=\"stylesheet\" href=\"./eventtalk/css/open-iconic-bootstrap.min.css\">
    <link rel=\"stylesheet\" href=\"./eventtalk/css/animate.css\">

    <link rel=\"stylesheet\" href=\"./eventtalk/css/owl.carousel.min.css\">
    <link rel=\"stylesheet\" href=\"./eventtalk/css/owl.theme.default.min.css\">
    <link rel=\"stylesheet\" href=\"./eventtalk/css/magnific-popup.css\">

    <link rel=\"stylesheet\" href=\"./eventtalk/css/aos.css\">

    <link rel=\"stylesheet\" href=\"./eventtalk/css/ionicons.min.css\">

    <link rel=\"stylesheet\" href=\"./eventtalk/css/bootstrap-datepicker.css\">
    <link rel=\"stylesheet\" href=\"./eventtalk/css/jquery.timepicker.css\">


    <link rel=\"stylesheet\" href=\"./eventtalk/css/flaticon.css\">
    <link rel=\"stylesheet\" href=\"./eventtalk/css/icomoon.css\">
    <link rel=\"stylesheet\" href=\"./eventtalk/css/style.css\">
    <script>
\t\t// Render localStorage JS:
\t\tif (localStorage.theme) document.documentElement.setAttribute(\"data-theme\", localStorage.theme);
\t\tif (localStorage.layout) document.documentElement.setAttribute(\"data-nav\", localStorage.navbar);
\t\tif (localStorage.layout) document.documentElement.setAttribute(\"dir\", localStorage.layout);
    </script>
</head>

<body class=\"geex-dashboard\">

    {% include \"./partials/header.html.twig\" %}



    <main class=\"geex-main-content\">


        {% include \"./partials/sidebar.html.twig\" %}


        {% include \"./partials/customizer.html.twig\" %}

\t\t<div class=\"geex-content\">
\t\t\t<div class=\"geex-content__section geex-content__blank\">
                   <div class=\"hero-wrap js-fullheight\" style=\"background-image: url('./eventtalk/images/bg_1.jpg');\" data-stellar-background-ratio=\"0.5\">

                      <div class=\"container\">
                        <div class=\"row no-gutters slider-text js-fullheight align-items-center justify-content-start\" data-scrollax-parent=\"true\">
                          <div class=\"col-xl-10 ftco-animate\" data-scrollax=\" properties: { translateY: '70%' }\">
                            <h1 class=\"mb-4\" data-scrollax=\"properties: { translateY: '30%', opacity: 1.6 }\"> Developer <br><span>Conference 2019</span></h1>
                            <p class=\"mb-4\" data-scrollax=\"properties: { translateY: '30%', opacity: 1.6 }\">December 21-24, 2019. Paris, Italy</p>
                            <div id=\"timer\" class=\"d-flex mb-3\">
                \t\t\t\t\t\t  <div class=\"time\" id=\"days\"></div>
                \t\t\t\t\t\t  <div class=\"time pl-4\" id=\"hours\"></div>
                \t\t\t\t\t\t  <div class=\"time pl-4\" id=\"minutes\"></div>
                \t\t\t\t\t\t  <div class=\"time pl-4\" id=\"seconds\"></div>
                \t\t\t\t\t\t</div>
                          </div>
                        </div>
                      </div>
                    </div>

                    <section class=\"ftco-section services-section bg-light\">
                      <div class=\"container\">
                        <div class=\"row d-flex\">
                          <div class=\"col-md-3 d-flex align-self-stretch ftco-animate\">
                            <div class=\"media block-6 services d-block\">
                              <div class=\"icon\"><span class=\"flaticon-placeholder\"></span></div>
                              <div class=\"media-body\">
                                <h3 class=\"heading mb-3\">Venue</h3>
                                <p>\t203 Fake St. Mountain View, San Francisco, California, USA</p>
                              </div>
                            </div>
                          </div>
                          <div class=\"col-md-3 d-flex align-self-stretch ftco-animate\">
                            <div class=\"media block-6 services d-block\">
                              <div class=\"icon\"><span class=\"flaticon-world\"></span></div>
                              <div class=\"media-body\">
                                <h3 class=\"heading mb-3\">Transport</h3>
                                <p>A small river named Duden flows by their place and supplies.</p>
                              </div>
                            </div>
                          </div>
                          <div class=\"col-md-3 d-flex align-self-stretch ftco-animate\">
                            <div class=\"media block-6 services d-block\">
                              <div class=\"icon\"><span class=\"flaticon-hotel\"></span></div>
                              <div class=\"media-body\">
                                <h3 class=\"heading mb-3\">Hotel</h3>
                                <p>A small river named Duden flows by their place and supplies.</p>
                              </div>
                            </div>
                          </div>
                          <div class=\"col-md-3 d-flex align-self-stretch ftco-animate\">
                            <div class=\"media block-6 services d-block\">
                              <div class=\"icon\"><span class=\"flaticon-cooking\"></span></div>
                              <div class=\"media-body\">
                                <h3 class=\"heading mb-3\">Restaurant</h3>
                                <p>A small river named Duden flows by their place and supplies.</p>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </section>

                    <section class=\"ftco-counter img\" id=\"section-counter\">
                    \t<div class=\"container\">
                    \t\t<div class=\"row d-flex\">
                    \t\t\t<div class=\"col-md-6 d-flex\">
                    \t\t\t\t<div class=\"img d-flex align-self-stretch\" style=\"background-image:url(./eventtalk/images/about.jpg);\"></div>
                    \t\t\t</div>
                    \t\t\t<div class=\"col-md-6 pl-md-5 py-5\">
                    \t\t\t\t<div class=\"row justify-content-start pb-3\">
                \t\t          <div class=\"col-md-12 heading-section ftco-animate\">
                \t\t          \t<span class=\"subheading\">Fun Facts</span>
                \t\t            <h2 class=\"mb-4\"><span>Fun</span> Facts</h2>
                \t\t            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>
                \t\t          </div>
                \t\t        </div>
                \t\t    \t\t<div class=\"row\">
                \t\t          <div class=\"col-md-6 justify-content-center counter-wrap ftco-animate\">
                \t\t            <div class=\"block-18 text-center py-4 bg-light mb-4\">
                \t\t              <div class=\"text\">
                \t\t              \t<div class=\"icon d-flex justify-content-center align-items-center\">
                \t\t              \t\t<span class=\"flaticon-guest\"></span>
                \t\t              \t</div>
                \t\t                <strong class=\"number\" data-number=\"30\">0</strong>
                \t\t                <span>Speakers</span>
                \t\t              </div>
                \t\t            </div>
                \t\t          </div>
                \t\t          <div class=\"col-md-6 justify-content-center counter-wrap ftco-animate\">
                \t\t            <div class=\"block-18 text-center py-4 bg-light mb-4\">
                \t\t              <div class=\"text\">
                \t\t              \t<div class=\"icon d-flex justify-content-center align-items-center\">
                \t\t              \t\t<span class=\"flaticon-handshake\"></span>
                \t\t              \t</div>
                \t\t                <strong class=\"number\" data-number=\"200\">0</strong>
                \t\t                <span>Sponsor</span>
                \t\t              </div>
                \t\t            </div>
                \t\t          </div>
                \t\t          <div class=\"col-md-6 justify-content-center counter-wrap ftco-animate\">
                \t\t            <div class=\"block-18 text-center py-4 bg-light mb-4\">
                \t\t              <div class=\"text\">
                \t\t              \t<div class=\"icon d-flex justify-content-center align-items-center\">
                \t\t              \t\t<span class=\"flaticon-chair\"></span>
                \t\t              \t</div>
                \t\t                <strong class=\"number\" data-number=\"2500\">0</strong>
                \t\t                <span>Total Seats</span>
                \t\t              </div>
                \t\t            </div>
                \t\t          </div>
                \t\t          <div class=\"col-md-6 justify-content-center counter-wrap ftco-animate\">
                \t\t            <div class=\"block-18 text-center py-4 bg-light mb-4\">
                \t\t              <div class=\"text\">
                \t\t              \t<div class=\"icon d-flex justify-content-center align-items-center\">
                \t\t              \t\t<span class=\"flaticon-idea\"></span>
                \t\t              \t</div>
                \t\t                <strong class=\"number\" data-number=\"40\">0</strong>
                \t\t                <span>Topics</span>
                \t\t              </div>
                \t\t            </div>
                \t\t          </div>
                \t\t        </div>
                \t        </div>
                        </div>
                    \t</div>
                    </section>

                    <section class=\"ftco-section\">
                    \t<div class=\"container\">
                    \t\t<div class=\"row justify-content-center mb-5 pb-3\">
                          <div class=\"col-md-7 text-center heading-section ftco-animate\">
                          \t<span class=\"subheading\">Speaker</span>
                            <h2 class=\"mb-4\"><span>Our</span> Speakers</h2>
                          </div>
                        </div>
                        <div class=\"row\">
                        \t<div class=\"col-md-12 ftco-animate\">
                        \t\t<div class=\"carousel-testimony owl-carousel\">
                        \t\t\t<div class=\"item\">
                        \t\t\t\t<div class=\"speaker\">
                \t\t\t        \t\t<img src=\"./eventtalk/images/speaker-1.jpg\" class=\"img-fluid\" alt=\"Colorlib HTML5 Template\">
                \t\t\t        \t\t<div class=\"text text-center py-3\">
                \t\t\t        \t\t\t<h3>John Adams</h3>
                \t\t\t        \t\t\t<span class=\"position\">Web Developer</span>
                \t\t\t        \t\t\t<ul class=\"ftco-social mt-3\">
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>
                \t\t\t              </ul>
                \t\t\t        \t\t</div>
                \t\t\t        \t</div>
                        \t\t\t</div>

                        \t\t\t<div class=\"item\">
                        \t\t\t\t<div class=\"speaker\">
                \t\t\t        \t\t<img src=\"./eventtalk/images/speaker-2.jpg\" class=\"img-fluid\" alt=\"Colorlib HTML5 Template\">
                \t\t\t        \t\t<div class=\"text text-center py-3\">
                \t\t\t        \t\t\t<h3>Paul George</h3>
                \t\t\t        \t\t\t<span class=\"position\">Web Developer</span>
                \t\t\t        \t\t\t<ul class=\"ftco-social mt-3\">
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>
                \t\t\t              </ul>
                \t\t\t        \t\t</div>
                \t\t\t        \t</div>
                        \t\t\t</div>

                        \t\t\t<div class=\"item\">
                        \t\t\t\t<div class=\"speaker\">
                \t\t\t        \t\t<img src=\"./eventtalk/images/speaker-3.jpg\" class=\"img-fluid\" alt=\"Colorlib HTML5 Template\">
                \t\t\t        \t\t<div class=\"text text-center py-3\">
                \t\t\t        \t\t\t<h3>James Smith</h3>
                \t\t\t        \t\t\t<span class=\"position\">Web Developer</span>
                \t\t\t        \t\t\t<ul class=\"ftco-social mt-3\">
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>
                \t\t\t              </ul>
                \t\t\t        \t\t</div>
                \t\t\t        \t</div>
                        \t\t\t</div>

                        \t\t\t<div class=\"item\">
                        \t\t\t\t<div class=\"speaker\">
                \t\t\t        \t\t<img src=\"./eventtalk/images/speaker-4.jpg\" class=\"img-fluid\" alt=\"Colorlib HTML5 Template\">
                \t\t\t        \t\t<div class=\"text text-center py-3\">
                \t\t\t        \t\t\t<h3>Angelie Crawford</h3>
                \t\t\t        \t\t\t<span class=\"position\">Web Developer</span>
                \t\t\t        \t\t\t<ul class=\"ftco-social mt-3\">
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>
                \t\t\t              </ul>
                \t\t\t        \t\t</div>
                \t\t\t        \t</div>
                        \t\t\t</div>

                        \t\t\t<div class=\"item\">
                        \t\t\t\t<div class=\"speaker\">
                \t\t\t        \t\t<img src=\"./eventtalk/images/speaker-5.jpg\" class=\"img-fluid\" alt=\"Colorlib HTML5 Template\">
                \t\t\t        \t\t<div class=\"text text-center py-3\">
                \t\t\t        \t\t\t<h3>Jackie Spears</h3>
                \t\t\t        \t\t\t<span class=\"position\">Entrepreneur</span>
                \t\t\t        \t\t\t<ul class=\"ftco-social mt-3\">
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>
                \t\t\t                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>
                \t\t\t              </ul>
                \t\t\t        \t\t</div>
                \t\t\t        \t</div>
                        \t\t\t</div>
                        \t\t</div>
                        \t</div>
                        </div>
                    \t</div>
                    </section>


                \t\t<section class=\"ftco-section bg-light\">
                \t\t\t<div class=\"container\">
                \t\t\t\t<div class=\"row justify-content-center mb-5 pb-3\">
                          <div class=\"col-md-7 text-center heading-section ftco-animate\">
                          \t<span class=\"subheading\">Schedule</span>
                            <h2 class=\"mb-4\"><span>Event</span> Schedule</h2>
                          </div>
                        </div>
                        <div class=\"ftco-search\">
                \t\t\t\t\t<div class=\"row\">
                            <div class=\"col-md-12 nav-link-wrap\">
                \t            <div class=\"nav nav-pills d-flex text-center\" id=\"v-pills-tab\" role=\"tablist\" aria-orientation=\"vertical\">
                \t              <a class=\"nav-link ftco-animate active\" id=\"v-pills-1-tab\" data-toggle=\"pill\" href=\"#v-pills-1\" role=\"tab\" aria-controls=\"v-pills-1\" aria-selected=\"true\">Day 01 <span>21 Dec. 2019</span></a>

                \t              <a class=\"nav-link ftco-animate\" id=\"v-pills-2-tab\" data-toggle=\"pill\" href=\"#v-pills-2\" role=\"tab\" aria-controls=\"v-pills-2\" aria-selected=\"false\">Day 02 <span>22 Dec. 2019</span></a>

                \t              <a class=\"nav-link ftco-animate\" id=\"v-pills-3-tab\" data-toggle=\"pill\" href=\"#v-pills-3\" role=\"tab\" aria-controls=\"v-pills-3\" aria-selected=\"false\">Day 03 <span>23 Dec. 2019</span></a>

                \t              <a class=\"nav-link ftco-animate\" id=\"v-pills-4-tab\" data-toggle=\"pill\" href=\"#v-pills-4\" role=\"tab\" aria-controls=\"v-pills-4\" aria-selected=\"false\">Day 04 <span>24 Dec. 2019</span></a>

                \t            </div>
                \t          </div>
                \t          <div class=\"col-md-12 tab-wrap\">

                \t            <div class=\"tab-content\" id=\"v-pills-tabContent\">

                \t              <div class=\"tab-pane fade show active\" id=\"v-pills-1\" role=\"tabpanel\" aria-labelledby=\"day-1-tab\">
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_1.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Introduction to Wordpress 5.0</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_2.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Best Practices For Programming WordPress</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_3.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Web Performance For Third Party Scripts</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              </div>

                \t              <div class=\"tab-pane fade\" id=\"v-pills-2\" role=\"tabpanel\" aria-labelledby=\"v-pills-day-2-tab\">
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_1.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Introduction to Wordpress 5.0</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_2.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Best Practices For Programming WordPress</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_3.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Web Performance For Third Party Scripts</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              </div>
                \t              <div class=\"tab-pane fade\" id=\"v-pills-3\" role=\"tabpanel\" aria-labelledby=\"v-pills-day-3-tab\">
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_1.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Introduction to Wordpress 5.0</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_2.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Best Practices For Programming WordPress</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_3.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Web Performance For Third Party Scripts</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              </div>
                \t              <div class=\"tab-pane fade\" id=\"v-pills-4\" role=\"tabpanel\" aria-labelledby=\"v-pills-day-4-tab\">
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_1.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Introduction to Wordpress 5.0</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_2.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Best Practices For Programming WordPress</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              \t<div class=\"speaker-wrap ftco-animate d-flex\">
                \t              \t\t<div class=\"img speaker-img\" style=\"background-image: url(./eventtalk/images/person_3.jpg);\"></div>
                \t              \t\t<div class=\"text pl-md-5\">
                \t              \t\t\t<span class=\"time\">08: - 10:00</span>
                \t              \t\t\t<h2><a href=\"#\">Web Performance For Third Party Scripts</a></h2>
                \t              \t\t\t<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                \t              \t\t\t<h3 class=\"speaker-name\">&mdash; <a href=\"#\">Brett Morgan</a> <span class=\"position\">Founder of Wordpress</span></h3>
                \t              \t\t</div>
                \t              \t</div>
                \t              </div>
                \t            </div>
                \t          </div>
                \t        </div>
                        </div>
                \t\t\t</div>
                \t\t</section>


                    <section class=\"ftco-section testimony-section\">
                      <div class=\"container\">
                        <div class=\"row justify-content-center mb-5 pb-3\">
                          <div class=\"col-md-7 text-center heading-section ftco-animate\">
                          \t<span class=\"subheading\">Testimonial</span>
                            <h2 class=\"mb-4\"><span>Happy</span> Clients</h2>
                          </div>
                        </div>
                        <div class=\"row ftco-animate\">
                          <div class=\"col-md-12\">
                            <div class=\"carousel-testimony owl-carousel ftco-owl\">
                              <div class=\"item\">
                                <div class=\"testimony-wrap text-center py-4 pb-5\">
                                  <div class=\"user-img mb-4\" style=\"background-image: url(./eventtalk/images/person_1.jpg)\">
                                    <span class=\"quote d-flex align-items-center justify-content-center\">
                                      <i class=\"icon-quote-left\"></i>
                                    </span>
                                  </div>
                                  <div class=\"text\">
                                    <p class=\"mb-4\">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                    <p class=\"name\">Roger Scott</p>
                                    <span class=\"position\">Marketing Manager</span>
                                  </div>
                                </div>
                              </div>
                              <div class=\"item\">
                                <div class=\"testimony-wrap text-center py-4 pb-5\">
                                  <div class=\"user-img mb-4\" style=\"background-image: url(./eventtalk/images/person_2.jpg)\">
                                    <span class=\"quote d-flex align-items-center justify-content-center\">
                                      <i class=\"icon-quote-left\"></i>
                                    </span>
                                  </div>
                                  <div class=\"text\">
                                    <p class=\"mb-4\">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                    <p class=\"name\">Roger Scott</p>
                                    <span class=\"position\">Interface Designer</span>
                                  </div>
                                </div>
                              </div>
                              <div class=\"item\">
                                <div class=\"testimony-wrap text-center py-4 pb-5\">
                                  <div class=\"user-img mb-4\" style=\"background-image: url(./eventtalk/images/person_3.jpg)\">
                                    <span class=\"quote d-flex align-items-center justify-content-center\">
                                      <i class=\"icon-quote-left\"></i>
                                    </span>
                                  </div>
                                  <div class=\"text\">
                                    <p class=\"mb-4\">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                    <p class=\"name\">Roger Scott</p>
                                    <span class=\"position\">UI Designer</span>
                                  </div>
                                </div>
                              </div>
                              <div class=\"item\">
                                <div class=\"testimony-wrap text-center py-4 pb-5\">
                                  <div class=\"user-img mb-4\" style=\"background-image: url(./eventtalk/images/person_1.jpg)\">
                                    <span class=\"quote d-flex align-items-center justify-content-center\">
                                      <i class=\"icon-quote-left\"></i>
                                    </span>
                                  </div>
                                  <div class=\"text\">
                                    <p class=\"mb-4\">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                    <p class=\"name\">Roger Scott</p>
                                    <span class=\"position\">Web Developer</span>
                                  </div>
                                </div>
                              </div>
                              <div class=\"item\">
                                <div class=\"testimony-wrap text-center py-4 pb-5\">
                                  <div class=\"user-img mb-4\" style=\"background-image: url(./eventtalk/images/person_1.jpg)\">
                                    <span class=\"quote d-flex align-items-center justify-content-center\">
                                      <i class=\"icon-quote-left\"></i>
                                    </span>
                                  </div>
                                  <div class=\"text\">
                                    <p class=\"mb-4\">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                                    <p class=\"name\">Roger Scott</p>
                                    <span class=\"position\">System Analyst</span>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </section>

                    <section class=\"ftco-section bg-light\">
                      <div class=\"container\">
                        <div class=\"row justify-content-center mb-5 pb-3\">
                          <div class=\"col-md-7 heading-section ftco-animate text-center\">
                            <span class=\"subheading\">Pricing Tables</span>
                            <h2 class=\"mb-1\"><span>Our</span> Ticket Pricing</h2>
                          </div>
                        </div>
                        <div class=\"row\">
                \t        <div class=\"col-md-4 ftco-animate\">
                \t          <div class=\"block-7\">
                \t            <div class=\"text-center\">
                \t            <h2 class=\"heading\">Personal</h2>
                \t            <span class=\"price\"><sup>\$</sup> <span class=\"number\">85</span></span>
                \t            <span class=\"excerpt d-block\">per Month</span>

                \t            <h3 class=\"heading-2 my-4\">Enjoy All The Features</h3>

                \t            <ul class=\"pricing-text mb-5\">
                \t              <li>Conference Seats</li>
                \t              <li>Free Wifi</li>
                \t              <li>Coffee Breaks</li>
                \t              <li>Lunch</li>
                \t              <li>Workshops</li>
                \t              <li>One Speakers</li>
                \t              <li>Papers</li>
                \t            </ul>

                \t            <a href=\"#\" class=\"btn btn-primary d-block px-2 py-3\">Buy Ticket</a>
                \t            </div>
                \t          </div>
                \t        </div>
                \t        <div class=\"col-md-4 ftco-animate\">
                \t          <div class=\"block-7\">
                \t            <div class=\"text-center\">
                \t            <h2 class=\"heading\">Small Team</h2>
                \t            <span class=\"price\"><sup>\$</sup> <span class=\"number\">200</span></span>
                \t            <span class=\"excerpt d-block\">per Month</span>

                \t            <h3 class=\"heading-2 my-4\">Enjoy All The Features</h3>

                \t            <ul class=\"pricing-text mb-5\">
                \t              <li>Conference Seats</li>
                \t              <li>Free Wifi</li>
                \t              <li>Coffee Breaks</li>
                \t              <li>Lunch</li>
                \t              <li>Workshops</li>
                \t              <li>One Speakers</li>
                \t              <li>Papers</li>
                \t            </ul>

                \t            <a href=\"#\" class=\"btn btn-primary d-block px-2 py-3\">Buy Ticket</a>
                \t            </div>
                \t          </div>
                \t        </div>
                \t        <div class=\"col-md-4 ftco-animate\">
                \t          <div class=\"block-7\">
                \t            <div class=\"text-center\">
                \t            <h2 class=\"heading\">Family Pack</h2>
                \t            <span class=\"price\"><sup>\$</sup> <span class=\"number\">499</span></span>
                \t            <span class=\"excerpt d-block\">per Month</span>

                \t            <h3 class=\"heading-2 my-4\">Enjoy All The Features</h3>

                \t            <ul class=\"pricing-text mb-5\">
                \t              <li>Conference Seats</li>
                \t              <li>Free Wifi</li>
                \t              <li>Coffee Breaks</li>
                \t              <li>Lunch</li>
                \t              <li>Workshops</li>
                \t              <li>One Speakers</li>
                \t              <li>Papers</li>
                \t            </ul>

                \t            <a href=\"#\" class=\"btn btn-primary d-block px-2 py-3\">Buy Ticket</a>
                \t            </div>
                \t          </div>
                \t        </div>
                \t      </div>
                      </div>
                    </section>

                    <section class=\"ftco-section bg-light\">
                      <div class=\"container\">
                        <div class=\"row justify-content-center mb-5 pb-3\">
                          <div class=\"col-md-7 heading-section text-center ftco-animate\">
                          \t<span class=\"subheading\">Our Blog</span>
                            <h2><span>Recent</span> Blog</h2>
                          </div>
                        </div>
                        <div class=\"row d-flex\">
                          <div class=\"col-md-4 d-flex ftco-animate\">
                          \t<div class=\"blog-entry justify-content-end\">
                              <a href=\"blog-single.html\" class=\"block-20\" style=\"background-image: url('./eventtalk/images/image_1.jpg');\">
                              </a>
                              <div class=\"text p-4 float-right d-block\">
                              \t<div class=\"d-flex align-items-center pt-2 mb-4\">
                              \t\t<div class=\"one\">
                              \t\t\t<span class=\"day\">07</span>
                              \t\t</div>
                              \t\t<div class=\"two\">
                              \t\t\t<span class=\"yr\">2019</span>
                              \t\t\t<span class=\"mos\">January</span>
                              \t\t</div>
                              \t</div>
                                <h3 class=\"heading mt-2\"><a href=\"#\">Why Lead Generation is Key for Business Growth</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                              </div>
                            </div>
                          </div>
                          <div class=\"col-md-4 d-flex ftco-animate\">
                          \t<div class=\"blog-entry justify-content-end\">
                              <a href=\"blog-single.html\" class=\"block-20\" style=\"background-image: url('./eventtalk/images/image_2.jpg');\">
                              </a>
                              <div class=\"text p-4 float-right d-block\">
                              \t<div class=\"d-flex align-items-center pt-2 mb-4\">
                              \t\t<div class=\"one\">
                              \t\t\t<span class=\"day\">07</span>
                              \t\t</div>
                              \t\t<div class=\"two\">
                              \t\t\t<span class=\"yr\">2019</span>
                              \t\t\t<span class=\"mos\">January</span>
                              \t\t</div>
                              \t</div>
                                <h3 class=\"heading mt-2\"><a href=\"#\">Why Lead Generation is Key for Business Growth</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                              </div>
                            </div>
                          </div>
                          <div class=\"col-md-4 d-flex ftco-animate\">
                          \t<div class=\"blog-entry\">
                              <a href=\"blog-single.html\" class=\"block-20\" style=\"background-image: url('./eventtalk/images/image_3.jpg');\">
                              </a>
                              <div class=\"text p-4 float-right d-block\">
                              \t<div class=\"d-flex align-items-center pt-2 mb-4\">
                              \t\t<div class=\"one\">
                              \t\t\t<span class=\"day\">06</span>
                              \t\t</div>
                              \t\t<div class=\"two\">
                              \t\t\t<span class=\"yr\">2019</span>
                              \t\t\t<span class=\"mos\">January</span>
                              \t\t</div>
                              \t</div>
                                <h3 class=\"heading mt-2\"><a href=\"#\">Why Lead Generation is Key for Business Growth</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </section>

                \t\t<section class=\"ftco-section-parallax\">
                      <div class=\"parallax-img d-flex align-items-center\">
                        <div class=\"container\">
                          <div class=\"row d-flex justify-content-center\">
                            <div class=\"col-md-7 text-center heading-section heading-section-white ftco-animate\">
                              <h2>Subcribe to our Newsletter</h2>
                              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in</p>
                              <div class=\"row d-flex justify-content-center mt-4 mb-4\">
                                <div class=\"col-md-8\">
                                  <form action=\"#\" class=\"subscribe-form\">
                                    <div class=\"form-group d-flex\">
                                      <input type=\"text\" class=\"form-control\" placeholder=\"Enter email address\">
                                      <input type=\"submit\" value=\"Subscribe\" class=\"submit px-3\">
                                    </div>
                                  </form>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </section>

                    <section class=\"ftco-gallery\">
                    \t<div class=\"container-wrap\">
                    \t\t<div class=\"row no-gutters\">
                \t\t\t\t\t<div class=\"col-md-3 ftco-animate\">
                \t\t\t\t\t\t<a href=\"./eventtalk/images/image_1.jpg\" class=\"gallery image-popup img d-flex align-items-center\" style=\"background-image: url(./eventtalk/images/image_1.jpg);\">
                \t\t\t\t\t\t\t<div class=\"icon mb-4 d-flex align-items-center justify-content-center\">
                    \t\t\t\t\t\t<span class=\"icon-instagram\"></span>
                    \t\t\t\t\t</div>
                \t\t\t\t\t\t</a>
                \t\t\t\t\t</div>
                \t\t\t\t\t<div class=\"col-md-3 ftco-animate\">
                \t\t\t\t\t\t<a href=\"./eventtalk/images/image_2.jpg\" class=\"gallery image-popup img d-flex align-items-center\" style=\"background-image: url(./eventtalk/images/image_2.jpg);\">
                \t\t\t\t\t\t\t<div class=\"icon mb-4 d-flex align-items-center justify-content-center\">
                    \t\t\t\t\t\t<span class=\"icon-instagram\"></span>
                    \t\t\t\t\t</div>
                \t\t\t\t\t\t</a>
                \t\t\t\t\t</div>
                \t\t\t\t\t<div class=\"col-md-3 ftco-animate\">
                \t\t\t\t\t\t<a href=\"./eventtalk/images/image_3.jpg\" class=\"gallery image-popup img d-flex align-items-center\" style=\"background-image: url(./eventtalk/images/image_3.jpg);\">
                \t\t\t\t\t\t\t<div class=\"icon mb-4 d-flex align-items-center justify-content-center\">
                    \t\t\t\t\t\t<span class=\"icon-instagram\"></span>
                    \t\t\t\t\t</div>
                \t\t\t\t\t\t</a>
                \t\t\t\t\t</div>
                \t\t\t\t\t<div class=\"col-md-3 ftco-animate\">
                \t\t\t\t\t\t<a href=\"./eventtalk/images/image_4.jpg\" class=\"gallery image-popup img d-flex align-items-center\" style=\"background-image: url(./eventtalk/images/image_4.jpg);\">
                \t\t\t\t\t\t\t<div class=\"icon mb-4 d-flex align-items-center justify-content-center\">
                    \t\t\t\t\t\t<span class=\"icon-instagram\"></span>
                    \t\t\t\t\t</div>
                \t\t\t\t\t\t</a>
                \t\t\t\t\t</div>
                        </div>
                    \t</div>
                    </section>

                    <footer class=\"ftco-footer ftco-bg-dark ftco-section\">
                      <div class=\"container\">
                        <div class=\"row mb-5\">
                          <div class=\"col-md\">
                            <div class=\"ftco-footer-widget mb-4\">
                              <h2 class=\"ftco-heading-2\">Eventalk</h2>
                              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                              <ul class=\"ftco-footer-social list-unstyled float-md-left float-lft mt-5\">
                                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>
                                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>
                                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>
                              </ul>
                            </div>
                          </div>
                          <div class=\"col-md\">
                            <div class=\"ftco-footer-widget mb-4 ml-md-5\">
                              <h2 class=\"ftco-heading-2\">Useful Links</h2>
                              <ul class=\"list-unstyled\">
                                <li><a href=\"#\" class=\"py-2 d-block\">Speakers</a></li>
                                <li><a href=\"#\" class=\"py-2 d-block\">Shcedule</a></li>
                                <li><a href=\"#\" class=\"py-2 d-block\">Events</a></li>
                                <li><a href=\"#\" class=\"py-2 d-block\">Blog</a></li>
                              </ul>
                            </div>
                          </div>
                          <div class=\"col-md\">
                             <div class=\"ftco-footer-widget mb-4\">
                              <h2 class=\"ftco-heading-2\">Privacy</h2>
                              <ul class=\"list-unstyled\">
                                <li><a href=\"#\" class=\"py-2 d-block\">Career</a></li>
                                <li><a href=\"#\" class=\"py-2 d-block\">About Us</a></li>
                                <li><a href=\"#\" class=\"py-2 d-block\">Contact Us</a></li>
                                <li><a href=\"#\" class=\"py-2 d-block\">Services</a></li>
                              </ul>
                            </div>
                          </div>
                          <div class=\"col-md\">
                            <div class=\"ftco-footer-widget mb-4\">
                            \t<h2 class=\"ftco-heading-2\">Have a Questions?</h2>
                            \t<div class=\"block-23 mb-3\">
                \t              <ul>
                \t                <li><span class=\"icon icon-map-marker\"></span><span class=\"text\">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
                \t                <li><a href=\"#\"><span class=\"icon icon-phone\"></span><span class=\"text\">+2 392 3929 210</span></a></li>
                \t                <li><a href=\"#\"><span class=\"icon icon-envelope\"></span><span class=\"text\">info@yourdomain.com</span></a></li>
                \t              </ul>
                \t            </div>
                            </div>
                          </div>
                        </div>
                        <div class=\"row\">
                          <div class=\"col-md-12 text-center\">

                            <p> Ce site est fait avec <i class=\"icon-heart color-danger\" aria-hidden=\"true\"></i> par Quartet!  </p>
                          </div>
                        </div>
                      </div>
                    </footer>

\t\t\t\t<div class=\"geex-content__error__wrapper\">
\t\t\t\t\t<div class=\"geex-content__error__content\">

\t\t\t\t\t</div><!-- .page-content -->
\t\t\t\t</div>
\t\t\t</div>
\t\t</div>
\t</main>
<script src=\"./eventtalk/js/jquery.min.js\"></script>
  <script src=\"./eventtalk/js/jquery-migrate-3.0.1.min.js\"></script>
  <script src=\"./eventtalk/js/popper.min.js\"></script>
  <script src=\"./eventtalk/js/bootstrap.min.js\"></script>
  <script src=\"./eventtalk/js/jquery.easing.1.3.js\"></script>
  <script src=\"./eventtalk/js/jquery.waypoints.min.js\"></script>
  <script src=\"./eventtalk/js/jquery.stellar.min.js\"></script>
  <script src=\"./eventtalk/js/owl.carousel.min.js\"></script>
  <script src=\"./eventtalk/js/jquery.magnific-popup.min.js\"></script>
  <script src=\"./eventtalk/js/aos.js\"></script>
  <script src=\"./eventtalk/js/jquery.animateNumber.min.js\"></script>
  <script src=\"./eventtalk/js/bootstrap-datepicker.js\"></script>
  <script src=\"./eventtalk/js/jquery.timepicker.min.js\"></script>
  <script src=\"./eventtalk/js/scrollax.min.js\"></script>
  <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false\"></script>
  <script src=\"./eventtalk/js/google-map.js\"></script>
  <script src=\"./eventtalk/js/main.js\"></script>

\t<!-- inject:js-->
\t<script src=\"./assets/vendor/js/jquery/jquery-3.5.1.min.js\"></script>
\t<script src=\"./assets/vendor/js/jquery/jquery-ui.js\"></script>
\t<script src=\"./assets/vendor/js/bootstrap/bootstrap.min.js\"></script>
\t<script src=\"./assets/js/main.js\"></script>
\t<!-- endinject-->
</body>

</html>", "pages/landingPage.html.twig", "C:\\Users\\BestPc\\Documents\\ProjetWeb\\geex\\templates\\pages\\landingPage.html.twig");
    }
}
