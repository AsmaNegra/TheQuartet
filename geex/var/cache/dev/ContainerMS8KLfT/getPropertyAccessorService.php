<?php

namespace ContainerMS8KLfT;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/**
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class getPropertyAccessorService extends App_KernelDevDebugContainer
{
    /**
     * Gets the private 'property_accessor' shared service.
     *
     * @return \Symfony\Component\PropertyAccess\PropertyAccessor
     */
    public static function do($container, $lazyLoad = true)
    {
        include_once \dirname(__DIR__, 4).''.\DIRECTORY_SEPARATOR.'vendor'.\DIRECTORY_SEPARATOR.'symfony'.\DIRECTORY_SEPARATOR.'property-access'.\DIRECTORY_SEPARATOR.'PropertyAccessorInterface.php';
        include_once \dirname(__DIR__, 4).''.\DIRECTORY_SEPARATOR.'vendor'.\DIRECTORY_SEPARATOR.'symfony'.\DIRECTORY_SEPARATOR.'property-access'.\DIRECTORY_SEPARATOR.'PropertyAccessor.php';
        include_once \dirname(__DIR__, 4).''.\DIRECTORY_SEPARATOR.'vendor'.\DIRECTORY_SEPARATOR.'symfony'.\DIRECTORY_SEPARATOR.'property-info'.\DIRECTORY_SEPARATOR.'PropertyReadInfoExtractorInterface.php';
        include_once \dirname(__DIR__, 4).''.\DIRECTORY_SEPARATOR.'vendor'.\DIRECTORY_SEPARATOR.'symfony'.\DIRECTORY_SEPARATOR.'property-info'.\DIRECTORY_SEPARATOR.'PropertyWriteInfoExtractorInterface.php';
        include_once \dirname(__DIR__, 4).''.\DIRECTORY_SEPARATOR.'vendor'.\DIRECTORY_SEPARATOR.'symfony'.\DIRECTORY_SEPARATOR.'property-info'.\DIRECTORY_SEPARATOR.'Extractor'.\DIRECTORY_SEPARATOR.'ConstructorArgumentTypeExtractorInterface.php';
        include_once \dirname(__DIR__, 4).''.\DIRECTORY_SEPARATOR.'vendor'.\DIRECTORY_SEPARATOR.'symfony'.\DIRECTORY_SEPARATOR.'property-info'.\DIRECTORY_SEPARATOR.'Extractor'.\DIRECTORY_SEPARATOR.'ReflectionExtractor.php';

        $a = ($container->privates['property_info.reflection_extractor'] ?? ($container->privates['property_info.reflection_extractor'] = new \Symfony\Component\PropertyInfo\Extractor\ReflectionExtractor()));

        return $container->privates['property_accessor'] = new \Symfony\Component\PropertyAccess\PropertyAccessor(3, 2, new \Symfony\Component\Cache\Adapter\ArrayAdapter(0, false), $a, $a);
    }
}
