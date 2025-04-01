<?php

/**
 * This file has been auto-generated
 * by the Symfony Routing Component.
 */

return [
    false, // $matchHost
    [ // $staticRoutes
        '/_profiler' => [[['_route' => '_profiler_home', '_controller' => 'web_profiler.controller.profiler::homeAction'], null, null, null, true, false, null]],
        '/_profiler/search' => [[['_route' => '_profiler_search', '_controller' => 'web_profiler.controller.profiler::searchAction'], null, null, null, false, false, null]],
        '/_profiler/search_bar' => [[['_route' => '_profiler_search_bar', '_controller' => 'web_profiler.controller.profiler::searchBarAction'], null, null, null, false, false, null]],
        '/_profiler/phpinfo' => [[['_route' => '_profiler_phpinfo', '_controller' => 'web_profiler.controller.profiler::phpinfoAction'], null, null, null, false, false, null]],
        '/_profiler/open' => [[['_route' => '_profiler_open_file', '_controller' => 'web_profiler.controller.profiler::openAction'], null, null, null, false, false, null]],
        '/todo' => [[['_route' => 'todo', '_controller' => 'App\\Controller\\AppController::todo'], null, null, null, false, false, null]],
        '/chat' => [[['_route' => 'chat', '_controller' => 'App\\Controller\\AppController::chat'], null, null, null, false, false, null]],
        '/calendar' => [[['_route' => 'calendar', '_controller' => 'App\\Controller\\AppController::calendar'], null, null, null, false, false, null]],
        '/chart' => [[['_route' => 'chart', '_controller' => 'App\\Controller\\FeaturesController::chart'], null, null, null, false, false, null]],
        '/badge' => [[['_route' => 'badge', '_controller' => 'App\\Controller\\FeaturesController::badge'], null, null, null, false, false, null]],
        '/button' => [[['_route' => 'button', '_controller' => 'App\\Controller\\FeaturesController::button'], null, null, null, false, false, null]],
        '/color' => [[['_route' => 'color', '_controller' => 'App\\Controller\\FeaturesController::color'], null, null, null, false, false, null]],
        '/form' => [[['_route' => 'form', '_controller' => 'App\\Controller\\FeaturesController::form'], null, null, null, false, false, null]],
        '/icon' => [[['_route' => 'icon', '_controller' => 'App\\Controller\\FeaturesController::icon'], null, null, null, false, false, null]],
        '/navigation' => [[['_route' => 'navigation', '_controller' => 'App\\Controller\\FeaturesController::navigation'], null, null, null, false, false, null]],
        '/typography' => [[['_route' => 'typography', '_controller' => 'App\\Controller\\FeaturesController::typography'], null, null, null, false, false, null]],
        '/fournisseur' => [[['_route' => 'app_fournisseur', '_controller' => 'App\\Controller\\FournisseurController::index'], null, null, null, false, false, null]],
        '/' => [[['_route' => 'root', '_controller' => 'App\\Controller\\HomeController::index'], null, null, null, false, false, null]],
        '/index' => [[['_route' => 'index', '_controller' => 'App\\Controller\\HomeController::index'], null, null, null, false, false, null]],
        '/index2' => [[['_route' => 'index2', '_controller' => 'App\\Controller\\HomeController::index2'], null, null, null, false, false, null]],
        '/index3' => [[['_route' => 'index3', '_controller' => 'App\\Controller\\HomeController::index3'], null, null, null, false, false, null]],
        '/index4' => [[['_route' => 'index4', '_controller' => 'App\\Controller\\HomeController::index4'], null, null, null, false, false, null]],
        '/blog' => [[['_route' => 'blog', '_controller' => 'App\\Controller\\PagesController::blog'], null, null, null, false, false, null]],
        '/blog-details' => [[['_route' => 'blogDetails', '_controller' => 'App\\Controller\\PagesController::blblogDetailsog'], null, null, null, false, false, null]],
        '/faq' => [[['_route' => 'faq', '_controller' => 'App\\Controller\\PagesController::faq'], null, null, null, false, false, null]],
        '/pricing' => [[['_route' => 'pricing', '_controller' => 'App\\Controller\\PagesController::pricing'], null, null, null, false, false, null]],
        '/testimonial' => [[['_route' => 'testimonial', '_controller' => 'App\\Controller\\PagesController::testimonial'], null, null, null, false, false, null]],
        '/terms' => [[['_route' => 'terms', '_controller' => 'App\\Controller\\PagesController::terms'], null, null, null, false, false, null]],
        '/signin' => [[['_route' => 'signin', '_controller' => 'App\\Controller\\PagesController::signin'], null, null, null, false, false, null]],
        '/signup' => [[['_route' => 'signup', '_controller' => 'App\\Controller\\PagesController::signup'], null, null, null, false, false, null]],
        '/forgot-password' => [[['_route' => 'forgot-password', '_controller' => 'App\\Controller\\PagesController::forgetPassword'], null, null, null, false, false, null]],
        '/verification' => [[['_route' => 'verification', '_controller' => 'App\\Controller\\PagesController::verification'], null, null, null, false, false, null]],
        '/error' => [[['_route' => 'error', '_controller' => 'App\\Controller\\PagesController::error'], null, null, null, false, false, null]],
        '/coming-soon' => [[['_route' => 'comingSoon', '_controller' => 'App\\Controller\\PagesController::commingSoon'], null, null, null, false, false, null]],
        '/maintenance' => [[['_route' => 'maintenance', '_controller' => 'App\\Controller\\PagesController::maintenance'], null, null, null, false, false, null]],
        '/blank-page' => [[['_route' => 'blankPage', '_controller' => 'App\\Controller\\PagesController::blankPage'], null, null, null, false, false, null]],
        '/landing' => [[['_route' => 'landing', '_controller' => 'App\\Controller\\PagesController::landing'], null, null, null, false, false, null]],
    ],
    [ // $regexpList
        0 => '{^(?'
                .'|/_(?'
                    .'|error/(\\d+)(?:\\.([^/]++))?(*:38)'
                    .'|wdt/([^/]++)(*:57)'
                    .'|profiler/([^/]++)(?'
                        .'|/(?'
                            .'|search/results(*:102)'
                            .'|router(*:116)'
                            .'|exception(?'
                                .'|(*:136)'
                                .'|\\.css(*:149)'
                            .')'
                        .')'
                        .'|(*:159)'
                    .')'
                .')'
            .')/?$}sDu',
    ],
    [ // $dynamicRoutes
        38 => [[['_route' => '_preview_error', '_controller' => 'error_controller::preview', '_format' => 'html'], ['code', '_format'], null, null, false, true, null]],
        57 => [[['_route' => '_wdt', '_controller' => 'web_profiler.controller.profiler::toolbarAction'], ['token'], null, null, false, true, null]],
        102 => [[['_route' => '_profiler_search_results', '_controller' => 'web_profiler.controller.profiler::searchResultsAction'], ['token'], null, null, false, false, null]],
        116 => [[['_route' => '_profiler_router', '_controller' => 'web_profiler.controller.router::panelAction'], ['token'], null, null, false, false, null]],
        136 => [[['_route' => '_profiler_exception', '_controller' => 'web_profiler.controller.exception_panel::body'], ['token'], null, null, false, false, null]],
        149 => [[['_route' => '_profiler_exception_css', '_controller' => 'web_profiler.controller.exception_panel::stylesheet'], ['token'], null, null, false, false, null]],
        159 => [
            [['_route' => '_profiler', '_controller' => 'web_profiler.controller.profiler::panelAction'], ['token'], null, null, false, true, null],
            [null, null, null, null, false, false, 0],
        ],
    ],
    null, // $checkCondition
];
